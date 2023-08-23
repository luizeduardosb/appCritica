package controllers;

import java.util.List;

import models.Critica;
import models.Game;
import play.mvc.Controller;

public class Criticas extends Controller {
	
	public static void form() {
		List<Game> games = Game.findAll();
		render(games);
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
		List<Game> games = Game.findAll();
		
		renderTemplate("Criticas/form.html", c, games);
	}
	
	public static void deletar(long id) {
		Critica c = Critica.findById(id);
		c.delete();
		
		listar();
	}
	
}
