package controllers;

import java.util.List;

import models.Critica;
import models.Game;
import models.Usuario;
import play.mvc.Controller;

public class Usuarios extends Controller {
	
	public static void register() {
		render();
	}
	
	public static void login() {
		render();
	}

	public static void salvar(Usuario usu) {
		if (validation.hasErrors()) {
			errosValidacao();
		}
		
		if (usu.perfil != "admin") {
			usu.perfil = "comum";
		}
		
		if (!usu.usuario.contains("@")) {
			usu.usuario = "@" + usu.usuario;
		}
		
		usu.save();
		Games.home();
	}
	
	public static void deletar(long id) {
		Usuario usu = Usuario.findById(id);
		usu.delete();
	}
	
	public static void editar(long id) {
		Usuario usu = Usuario.findById(id);

		renderTemplate("Usuarios/form.html", usu);
	}
	
	public static void entrar(String usuario, String senha) {
		Usuario usu = Usuario.find("usuario = ?1 and senha = ?2", usuario, senha).first();
		
		if (usu != null) {
			session.put("user", usu.usuario);
			session.put("perfil", usu.perfil);
			Games.home();
		} else {
			validacaoUser();
		}	
	}
	
	private static void validacaoUser() {
		params.flash();
		validation.keep();
		flash.error("Usuário ou senha incorretos");
		login();
	}
	
	private static void errosValidacao() {
		params.flash();
		validation.keep();
		flash.error("Não sou especialista, mas creio que há um erro em seu formulário... Corrija e tente novamente");
		register();
	}
	
	public static void sair() {
		session.clear();
		Games.home();
	}
}
