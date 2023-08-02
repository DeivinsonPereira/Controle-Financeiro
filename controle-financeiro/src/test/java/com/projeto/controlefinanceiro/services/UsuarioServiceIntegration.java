package com.projeto.controlefinanceiro.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.controlefinanceiro.dto.UsuarioDTO;
import com.projeto.controlefinanceiro.repositories.UsuarioRepository;

@SpringBootTest
@Transactional
public class UsuarioServiceIntegration {

	@Autowired
	private UsuarioService service;
	
	@Autowired
	private UsuarioRepository repository;
	
	private Long existingId;
	private Long countTotalProducts;
	
	
	@BeforeEach
	void setUp() throws Exception {
		existingId = 1L;
		countTotalProducts = 10L;
	}
	
	@Test
	public void deleteShouldDeleteResourceWhenIdExists() {
		
		service.delete(existingId);
		
		Assertions.assertEquals(countTotalProducts -1 , repository.count());
		
	}
	
	@Test
	public void findAllPagedShouldReturnPageWhenPage0Size10() {
		
		PageRequest pageRequest = PageRequest.of(0, 10);
		
		Page<UsuarioDTO> result = service.findAllPaged(pageRequest);
		
		Assertions.assertFalse(result.isEmpty());
		Assertions.assertEquals(0, result.getNumber());
		Assertions.assertEquals(10, result.getSize());
		Assertions.assertEquals(countTotalProducts, result.getTotalElements());
	}
	
	@Test
	public void findAllPagedShouldReturnEmptyPageWhenPageDoesNotExist() {
		
		PageRequest pageRequest = PageRequest.of(50, 10);
		
		Page<UsuarioDTO> result = service.findAllPaged(pageRequest);
		
		Assertions.assertTrue(result.isEmpty());
	}
	
	@Test
	public void findAllPagedShouldReturnSortedPageWhenSortByName() {
		
		PageRequest pageRequest = PageRequest.of(0, 10, Sort.by("nome"));
		
		Page<UsuarioDTO> result = service.findAllPaged(pageRequest);
		
		Assertions.assertFalse(result.isEmpty());
		Assertions.assertEquals("Fernanda de Cassia", result.getContent().get(0).getNome());
		Assertions.assertEquals("Henrique de Moraes", result.getContent().get(1).getNome());
		Assertions.assertEquals("Joao Carlos da Silva", result.getContent().get(2).getNome());
	}
	
}
