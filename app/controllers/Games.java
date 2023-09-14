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
	
	public static void listar() {
		String busca = params.get("busca");
		List<Game> lista = Game.findAll();
		
		if (busca == null || busca.isEmpty()) {
			lista = Game.findAll();			
		} else {
			lista = Game.find("lower(nome) like ?1",
					"%"+ busca.toLowerCase() +"%").fetch();
		}

		render(lista, busca);	
	}
	
	public static void editar(long id) {
		Game g = Game.findById(id);
		renderTemplate("Games/form.html", g);
	}
	
	public static void deletar(long id) {
		Game g = Game.findById(id);
		g.delete();
		
		
		listar();
	}
	
}
