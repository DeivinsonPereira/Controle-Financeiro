package com.projeto.controlefinanceiro.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.controlefinanceiro.dto.RoleDTO;
import com.projeto.controlefinanceiro.dto.UsuarioDTO;
import com.projeto.controlefinanceiro.dto.UsuarioInsertDTO;
import com.projeto.controlefinanceiro.dto.UsuarioUpdateDTO;
import com.projeto.controlefinanceiro.entities.Role;
import com.projeto.controlefinanceiro.entities.Usuario;
import com.projeto.controlefinanceiro.repositories.RoleRepository;
import com.projeto.controlefinanceiro.repositories.UsuarioRepository;
import com.projeto.controlefinanceiro.services.exceptions.DatabaseException;
import com.projeto.controlefinanceiro.services.exceptions.ResourceNotFoundException;

@Service
public class UsuarioService {

		@Autowired
		private BCryptPasswordEncoder passwordEncoder;
	
		@Autowired
		private UsuarioRepository usuarioRepository;
		
		@Autowired
		private RoleRepository roleRepository;
		
		
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
			entity.setSenha(passwordEncoder.encode(dto.getSenha()));
			entity = usuarioRepository.save(entity);
			return new UsuarioDTO(entity);
		}

		@Transactional
		public UsuarioDTO update(Long id, UsuarioUpdateDTO dto) {
			try {
				Usuario entity = usuarioRepository.getReferenceById(id);
				copyDtoToEntity(dto,entity);
				entity = usuarioRepository.save(entity);
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
