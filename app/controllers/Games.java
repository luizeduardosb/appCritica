package controllers;

import java.util.List;

import models.Critica;
import models.Game;
import play.mvc.Controller;

public class Games extends Controller {
	
	public static void form() {
		render();
	}
	
	public static void salvar(Game g) {
		g.save();
		form();
	}
	
	public static void home() {
		List<Game> lista = Game.findAll();

		render(lista);	
	}
	
	public static void editar(long id) {
		Game g = Game.findById(id);
		renderTemplate("Games/form.html", g);
	}
	
	public static void deletar(long id) {
		Game g = Game.findById(id);
		g.delete();
		
		
		home();
	}
	
}
