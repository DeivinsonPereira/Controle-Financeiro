package com.projeto.controlefinanceiro.dto;

import com.projeto.controlefinanceiro.services.validation.UsuarioUpdateValid;

@UsuarioUpdateValid
public class UsuarioUpdateDTO extends UsuarioDTO{
	
	private Long id;
	private String nome;
	private String email;

	public UsuarioUpdateDTO() {
	}

	public UsuarioUpdateDTO(UsuarioDTO usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
