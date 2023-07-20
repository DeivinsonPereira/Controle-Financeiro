package com.projeto.controlefinanceiro.dto;

import com.projeto.controlefinanceiro.entities.Usuario;

public class UsuarioMinDTO {

	private Long id;
	private String nome;
	private String email;
	private String senha;
	private Long telefone;
	
	public UsuarioMinDTO(Usuario entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.email = entity.getEmail();
		this.senha = entity.getSenha();
		this.telefone = entity.getTelefone();
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

	public String getSenha() {
		return senha;
	}

	public Long getTelefone() {
		return telefone;
	}



	
}
