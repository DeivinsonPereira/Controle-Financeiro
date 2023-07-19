package com.projeto.controlefinanceiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.controlefinanceiro.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
