package com.projeto.controlefinanceiro.services;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.projeto.controlefinanceiro.dto.UsuarioDTO;
import com.projeto.controlefinanceiro.dto.UsuarioUpdateDTO;
//import com.projeto.controlefinanceiro.dto.UsuarioUpdateDTO;
import com.projeto.controlefinanceiro.entities.Usuario;
import com.projeto.controlefinanceiro.repositories.UsuarioRepository;
import com.projeto.controlefinanceiro.services.exceptions.DatabaseException;
import com.projeto.controlefinanceiro.services.exceptions.ResourceNotFoundException;
import com.projeto.controlefinanceiro.tests.Factory;

@ExtendWith(SpringExtension.class)
public class UsuarioServiceTests {

	@InjectMocks
	private UsuarioService service;
	
	@Mock
	private UsuarioRepository repository;
	
	private Long existingId;
	private Long nonExistingId;
	private Long dependentId;
	private Usuario usuario;
	private PageImpl<Usuario> page;
	
	@BeforeEach
	void setUp() throws Exception {
		existingId = 1L;
		nonExistingId = 2L;
		dependentId = 3L;
		usuario = Factory.createUsuario();
		page = new PageImpl<>(List.of(usuario));
		
		
		when(repository.findAll((Pageable)ArgumentMatchers.any())).thenReturn(page);
		when(repository.save(ArgumentMatchers.any())).thenReturn(usuario);
		when(repository.findById(existingId)).thenReturn(Optional.of(usuario));
		when(repository.findById(nonExistingId)).thenReturn(Optional.empty());
		
		when(repository.getReferenceById(existingId)).thenReturn(usuario);
		when(repository.getReferenceById(nonExistingId)).thenThrow(EntityNotFoundException.class);
		
		doNothing().when(repository).deleteById(existingId);
		doThrow(EmptyResultDataAccessException.class).when(repository).deleteById(nonExistingId);
		doThrow(DataIntegrityViolationException.class).when(repository).deleteById(dependentId);
	}
	
	@Test
	public void findByIdShouldReturnUsuarioDTOWhenExistId() {
		
		UsuarioDTO result = service.findById(existingId);
		
		Assertions.assertNotNull(result);
		verify(repository).findById(existingId);
	}
	
	@Test
	public void findByIdShouldThrowResourceNotFoundExceptionWhenIdDoesNotExists() {
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			service.findById(nonExistingId);
			verify(repository).findById(nonExistingId);
		});
	}
	
	@Test
	public void updateShouldReturnUsuarioDTOWhenIdExists() {
		
		UsuarioDTO usuarioDTO = Factory.createUsuarioDTO();
		
		UsuarioUpdateDTO usuarioUpdate = new UsuarioUpdateDTO(usuarioDTO);
		
		UsuarioDTO result = service.update(existingId, usuarioUpdate);
		
		Assertions.assertNotNull(result.getId());
		
	}
	
	@Test
	public void updateShouldThrowResourceNotFoundExceptionWhenIdDoesNotExists() {
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			UsuarioDTO usuarioDTO = Factory.createUsuarioDTO();
			UsuarioUpdateDTO usuarioUpdate = new UsuarioUpdateDTO(usuarioDTO);
			service.update(nonExistingId,usuarioUpdate);
			verify(repository).findById(nonExistingId);
		});
	}
	
	@Test
	public void findAllPagedShouldReturnPage() {
		
		Pageable pageable = PageRequest.of(0, 10);
		
		Page<UsuarioDTO> result = service.findAllPaged(pageable);
		
		Assertions.assertNotNull(result);
		verify(repository).findAll(pageable);
	}
	
	@Test
	public void deleteShouldDoNothingWhenIdExists() {
		
		Assertions.assertDoesNotThrow(() -> {
			service.delete(existingId);
		});
		
		verify(repository, Mockito.times(1)).deleteById(existingId);
	}
	
	@Test
	public void deleteShouldThrowResourceNotFoundExceptionWhenIdDoesNotExists() {
		
		Assertions.assertThrows(ResourceNotFoundException.class,() -> {
			service.delete(nonExistingId);
		});
		
		verify(repository, Mockito.times(1)).deleteById(nonExistingId);
	}
	
	@Test
	public void deleteShouldThrowDatabaseExceptionWhenDependentId() {
		
		Assertions.assertThrows(DatabaseException.class,() -> {
			service.delete(dependentId);
		});
		
		verify(repository, Mockito.times(1)).deleteById(dependentId);
	}
	
}
