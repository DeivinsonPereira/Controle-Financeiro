package com.projeto.controlefinanceiro.dto;

import com.projeto.controlefinanceiro.services.validation.UsuarioInsertValid;

@UsuarioInsertValid
public class UsuarioInsertDTO extends UsuarioDTO {

	private String senha;

	public UsuarioInsertDTO() {
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
