package com.projeto.controlefinanceiro.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscatalog.dto.UsuarioInsertDTO;
import com.devsuperior.dscatalog.dto.UsuarioUpdateDTO;
import com.projeto.controlefinanceiro.dto.RoleDTO;
import com.projeto.controlefinanceiro.dto.UsuarioDTO;
import com.projeto.controlefinanceiro.entities.Role;
import com.projeto.controlefinanceiro.entities.Usuario;
import com.projeto.controlefinanceiro.repositories.UsuarioRepository;
import com.projeto.controlefinanceiro.services.exceptions.DatabaseException;
import com.projeto.controlefinanceiro.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioService {

		@Autowired
		private UsuarioRepository usuarioRepository;
		
		
		@Transactional(readOnly = true)
		public UsuarioDTO findById(Long id) {
			Optional<Usuario> obj = usuarioRepository.findById(id);
			Usuario entity = obj.orElseThrow(() -> new ResourceNotFoundException("Ocorreu um erro!"));
			return new UsuarioDTO(entity);
		}
	
		@Transactional(readOnly = true)
		public Page<UsuarioDTO> findAllPaged(Pageable pageable) {
			Page<Usuario> result = usuarioRepository.findAll(pageable);
			return result.map(x -> new UsuarioDTO(x));
		}
	
		@Transactional
		public UsuarioDTO insert(UsuarioInsertDTO dto) {
			Usuario entity = new Usuario();
			copyDtoToEntity(dto,entity);
			entity.setPassword(passwordEncoder.encode(dto.getPassword()));
			entity = userRepository.save(entity);
			return new UsuarioDTO(entity);
		}

		@Transactional
		public UsuarioDTO update(Long id, UsuarioUpdateDTO dto) {
			try {
				Usuario entity = userRepository.getReferenceById(id);
				copyDtoToEntity(dto,entity);
				entity = userRepository.save(entity);
				return new UsuarioDTO(entity);
			} catch (EntityNotFoundException e) {
				throw new ResourceNotFoundException("An unexpected error occurred.");
			}
		}
		
		public void delete(Long id) {
				try {
					usuarioRepository.deleteById(id);
				}
				catch(EmptyResultDataAccessException e) {
					throw new ResourceNotFoundException("Id not found: " + id);
				}
				catch(DataIntegrityViolationException e) {
					throw new DatabaseException("Integrity violation");
				}
		}
	
		private void copyDtoToEntity(UsuarioDTO dto, Usuario entity) {
			entity.setNome(dto.getNome());
			entity.setEmail(dto.getEmail());
			
			entity.getRoles().clear();
			for (RoleDTO roleDto : dto.getRoles()) {
				Role role = roleRepository.getReferenceById(roleDto.getId());
				entity.getRoles().add(role);
			}
			
		}
}
