package com.projeto.controlefinanceiro.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.controlefinanceiro.dto.UsuarioDTO;
import com.projeto.controlefinanceiro.dto.UsuarioInsertDTO;
import com.projeto.controlefinanceiro.dto.UsuarioUpdateDTO;
import com.projeto.controlefinanceiro.services.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id) {
		UsuarioDTO result =  usuarioService.findById(id);
		return ResponseEntity.ok().body(result);
	}
	
	@GetMapping
	public ResponseEntity<Page<UsuarioDTO>> findAll(Pageable pageable){
		Page<UsuarioDTO> list = usuarioService.findAllPaged(pageable);
		
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<UsuarioDTO> insert(@Valid @RequestBody UsuarioInsertDTO dto){
		UsuarioDTO newDto = usuarioService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newDto.getId()).toUri();
		return ResponseEntity.created(uri).body(newDto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<UsuarioDTO> update(@PathVariable Long id,@Valid @RequestBody UsuarioUpdateDTO dto){
		UsuarioDTO newDto = usuarioService.update(id, dto);
		return ResponseEntity.ok().body(newDto);
	}
	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		usuarioService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
