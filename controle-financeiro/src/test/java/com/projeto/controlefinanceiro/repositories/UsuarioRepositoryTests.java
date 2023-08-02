package com.projeto.controlefinanceiro.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.projeto.controlefinanceiro.entities.Usuario;
import com.projeto.controlefinanceiro.tests.Factory;

@DataJpaTest
public class UsuarioRepositoryTests {

	@Autowired
	private UsuarioRepository repository;
	
	private Long nonExistingId;
	private Long existsId;
	private long countTotalUsuarios;
	
	@BeforeEach
	void setUp() throws Exception{
		existsId = 1L;
		nonExistingId = 1000L;
		countTotalUsuarios = 10L;
		
	}
	
	@Test
	public void deleteShouldDeleteObjectWhenIdExists() {
		
		Optional<Usuario> usuario = repository.findById(existsId);

		Assertions.assertTrue(usuario.isPresent());

	    repository.deleteById(existsId);

	    Optional<Usuario> result = repository.findById(existsId);
	    Assertions.assertFalse(result.isPresent());
	}
	
	@Test
	public void saveShouldPersistWithAutoIncrementWhenIdIsNull() {
		
		Usuario usuario = Factory.createUsuario();
		usuario.setId(null);
		
		usuario = repository.save(usuario);
		
		Assertions.assertNotNull(usuario.getId());
		Assertions.assertEquals(countTotalUsuarios + 1, usuario.getId());
	}
	
	@Test
	public void findByIdShouldReturnNonEmptyOptionalUsuarioWhenIdExist() {
		
		Optional<Usuario> result = repository.findById(existsId);
		
		Assertions.assertTrue(result.isPresent());
	}
	
	@Test
	public void findByIdShouldReturnEmptyOptionalUsuarioWhenIdDoesNotExist() {
		
		Optional<Usuario> result = repository.findById(nonExistingId);
		
		Assertions.assertTrue(result.isEmpty());
	}
}
