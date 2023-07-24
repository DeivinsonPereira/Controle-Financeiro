package com.projeto.controlefinanceiro.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.controlefinanceiro.dto.UsuarioDTO;
import com.projeto.controlefinanceiro.entities.Usuario;
import com.projeto.controlefinanceiro.repositories.UsuarioRepository;
import com.projeto.controlefinanceiro.services.exceptions.DatabaseException;
import com.projeto.controlefinanceiro.services.exceptions.ResourceNotFoundException;

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
	
}
