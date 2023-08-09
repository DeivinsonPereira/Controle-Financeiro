package com.projeto.controlefinanceiro.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projeto.controlefinanceiro.dto.UsuarioDTO;
import com.projeto.controlefinanceiro.dto.UsuarioUpdateDTO;
import com.projeto.controlefinanceiro.tests.Factory;
import com.projeto.controlefinanceiro.tests.TokenUtil;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class UsuarioControllerIntegration {

	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private TokenUtil tokenUtil;
	
	private Long existingId;
    private Long nonExistingId;
	private Long countTotalUsuarios;
	private String adminUsername;
	private String adminPassword;
	
	
	@BeforeEach
	void setUp() throws Exception {
		existingId = 1L;
		nonExistingId = 1000L;
		countTotalUsuarios = 10L;
		adminUsername = "joaocarlos@gmail.com";
		adminPassword = "123456";
	}
	
	@Test
	public void findAllShouldReturnSortedPageWhenSortByName() throws Exception {
		
		String accessToken = tokenUtil.obtainAccessToken(mockMvc, adminUsername, adminPassword);
		
		UsuarioDTO dto = Factory.createUsuarioDTO();
		String jsonBody = objectMapper.writeValueAsString(dto);
		
		ResultActions result = 
				mockMvc.perform(get("/usuarios?page=0&size=12&sort=nome,asc")
						.header("Authorization", "Bearer " + accessToken)
						.content(jsonBody)
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$.totalElements").value(countTotalUsuarios));
		result.andExpect(jsonPath("$.content").exists());
		result.andExpect(jsonPath("$.content[0].nome").value("Fernanda de Cassia"));
		result.andExpect(jsonPath("$.content[1].nome").value("Henrique de Moraes"));
		result.andExpect(jsonPath("$.content[2].nome").value("Joao Carlos da Silva"));
	}
	
	@Test
	public void updateShouldReturnUsuarioDTOWhenIdExists() throws Exception {
		
		String accessToken = tokenUtil.obtainAccessToken(mockMvc, adminUsername, adminPassword);
		
		UsuarioDTO dto = Factory.createUsuarioDTO();
		UsuarioUpdateDTO usuarioUpdate = new UsuarioUpdateDTO(dto);
		String jsonBody = objectMapper.writeValueAsString(usuarioUpdate);
		
		String expectedName = dto.getNome();
		
		ResultActions result = 
				mockMvc.perform(put("/usuarios/{id}",existingId)
						.header("Authorization", "Bearer " + accessToken)
						.content(jsonBody)
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$.id").value(existingId));
		result.andExpect(jsonPath("$.nome").value(expectedName));
	}
	
	@Test
	public void updateShouldReturnNotFoundWhenIdDoesNotExists() throws Exception {
		
		String accessToken = tokenUtil.obtainAccessToken(mockMvc, adminUsername, adminPassword);
		
		UsuarioDTO usuarioDTO = Factory.createUsuarioDTO();
		String jsonBody = objectMapper.writeValueAsString(usuarioDTO);
		
		ResultActions result = 
				mockMvc.perform(put("/usuarios/{id}",nonExistingId)
						.header("Authorization", "Bearer " + accessToken)
						.content(jsonBody)
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isNotFound());
	}
}
