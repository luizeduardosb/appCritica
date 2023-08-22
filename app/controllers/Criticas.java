package controllers;

import java.util.List;

import models.Critica;
import play.mvc.Controller;

public class Criticas extends Controller {
	
	public static void form() {
		render();
	}
	
	public static void salvar(Critica c) {
		c.save();
		form();
	}
	
	public static void listar() {		
		List<Critica> lista = Critica.findAll();

		render(lista);	
	}
	
	public static void editar(long id) {
		Critica c = Critica.findById(id);
		renderTemplate("Criticas/form.html", c);
	}
	
	public static void deletar(long id) {
		Critica c = Critica.findById(id);
		c.delete();
		
		listar();
	}
	
}
