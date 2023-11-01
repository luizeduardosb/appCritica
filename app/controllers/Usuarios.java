package controllers;

import java.util.List;

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
		if (usu.perfil != "admin") {
			usu.perfil = "comum";
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
			login();
		}	
	}
	
	public static void sair() {
		session.clear();
		Games.home();
		
	}
}
