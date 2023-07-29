package com.projeto.controlefinanceiro.dto;

import java.util.HashSet;
import java.util.Set;

import com.projeto.controlefinanceiro.entities.Usuario;

public class UsuarioDTO {

	
	private Long id;
	private String nome;
	private String email;
	
	private Set<RoleDTO> roles = new HashSet<>();
	
	public UsuarioDTO() {
	}
	
	public UsuarioDTO(Long id, String nome, String email) {
		this.id = id;
		this.nome = nome;
		this.email = email;
	}

	public UsuarioDTO(Usuario entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.email = entity.getEmail();
		entity.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public Set<RoleDTO> getRoles() {
		return roles;
	}

	
}
