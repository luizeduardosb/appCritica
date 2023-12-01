package controllers;

import annotations.Administrador;
import play.mvc.Before;
import play.mvc.Controller;

public class Seguranca extends Controller {
	
	@Before(unless={"Games.home", "Games.detalhar"})
	static void autenticacao() {
		if (session.get("user") == null) {
			Usuarios.login();
		}
	} 
	
	@Before
	static void verificarAdmin() {
		String perfil = session.get("perfil");
		Administrador adminAnnotation = getActionAnnotation(Administrador.class);
		if (adminAnnotation != null && !"admin".equals(perfil)) {
			forbidden("Apenas admins");		
		}
	}
	
}
