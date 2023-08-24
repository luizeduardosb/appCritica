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
		String busca = params.get("busca");
		
		List<Critica> lista = Critica.findAll();
		/* if (busca == null || busca.isEmpty()) {
			lista = Critica.findAll();			
		} else {
			lista = Critica.find("lower(usuario) like ?1",
					"%"+ busca.toLowerCase() +"%").fetch();
		} */
		
		if (busca == null || busca.isEmpty()) {
			lista = Critica.findAll();			
		} else {
			lista = Critica.find("lower(spoiler) like ?1",
					"%"+ busca.toLowerCase() +"%").fetch();
		}	
			
		render(lista, busca);
		
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
