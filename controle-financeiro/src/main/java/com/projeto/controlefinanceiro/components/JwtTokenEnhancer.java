package com.projeto.controlefinanceiro.components;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.projeto.controlefinanceiro.entities.Usuario;
import com.projeto.controlefinanceiro.repositories.UsuarioRepository;

@Component
public class JwtTokenEnhancer implements TokenEnhancer {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//adicionar informações ou campo como id no token
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		Usuario usuario = usuarioRepository.findByEmail(authentication.getName());
		
		Map<String, Object> map = new HashMap<>();
		map.put("usuarioName", usuario.getNome());
		map.put("usuarioId", usuario.getId());
		
		DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) accessToken;
		token.setAdditionalInformation(map);
		
		return accessToken;
	}
}
