package com.projeto.controlefinanceiro.tests;

import com.projeto.controlefinanceiro.dto.UsuarioDTO;
import com.projeto.controlefinanceiro.dto.UsuarioUpdateDTO;
import com.projeto.controlefinanceiro.entities.Role;
import com.projeto.controlefinanceiro.entities.Usuario;

public class Factory {

	public static Usuario createUsuario() {
		Usuario usuario = new Usuario(1L, "Anderson antunes", "anderson@gmail.com", "123456");
		usuario.getRoles().add(new Role(null, "ROLE_ADMIN"));
		return usuario;
		
	}
	
	public static UsuarioDTO createUsuarioDTO() {
		Usuario usuario = createUsuario();
		return new UsuarioDTO(usuario);
	}
	
	public static UsuarioUpdateDTO createUsuarioUpdateDTO() {
		UsuarioDTO usuario = createUsuarioDTO();
		return new UsuarioUpdateDTO(usuario);
	}
}
