package com.projeto.controlefinanceiro.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.projeto.controlefinanceiro.services.validation.UsuarioUpdateValid;

@UsuarioUpdateValid
public class UsuarioUpdateDTO extends UsuarioDTO{
	
	private Long id;
	
	@Size(min = 5, max = 60, message = "Deve ter entre 5 e 60 caracteres")
	@NotBlank(message = "Campo requerido")
	private String nome;
	
	@Email(message = "Favor entrar um email válido")
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
