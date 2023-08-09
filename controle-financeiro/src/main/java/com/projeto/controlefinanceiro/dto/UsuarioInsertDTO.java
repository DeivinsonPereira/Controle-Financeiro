package com.projeto.controlefinanceiro.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.projeto.controlefinanceiro.services.validation.UsuarioInsertValid;

@UsuarioInsertValid
public class UsuarioInsertDTO extends UsuarioDTO {

	@NotBlank(message = "Campo requerido")
	@Min(value = 6, message = "Deve haver pelo menos 6 digitos")
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
