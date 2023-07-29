package com.projeto.controlefinanceiro.dto;

import com.projeto.controlefinanceiro.entities.Role;

public class RoleDTO {

	private Long id;
	private String autorizacao;
	
	public RoleDTO() {
	}

	public RoleDTO(Long id, String autorizacao) {
		this.id = id;
		this.autorizacao = autorizacao;
	}

	public RoleDTO(Role entity) {
		super();
		this.id = entity.getId();
		this.autorizacao = entity.getAuthority();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAutorizacao() {
		return autorizacao;
	}

	public void setAutorizacao(String autorizacao) {
		this.autorizacao = autorizacao;
	}
	
	
	
	
	
	
}
