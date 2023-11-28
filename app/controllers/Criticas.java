package controllers;

import java.util.Date;
import java.util.List;

import models.Critica;
import models.Game;
import models.Usuario;
import play.mvc.Controller;
import play.mvc.With;

@With(Seguranca.class)
public class Criticas extends Controller {

	public static void form() {
		List<Game> games = Game.findAll();
		List<Usuario> usuarios = Usuario.findAll();
		render(games, usuarios);
	}

	public static void salvar(Critica c) {
		c.nomeUser = session.get("user");
		c.data = new Date();
		
		
		c.save();
		listar();
	}

		public static void listar() {
		String busca = params.get("busca");
		List<Critica> lista = Critica.findAll();
		
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
		List<Usuario> usuarios = Usuario.findAll();

		renderTemplate("Criticas/form.html", c, games, usuarios);
	}

	public static void deletar(long id) {
		Critica c = Critica.findById(id);
		c.delete();

		listar();
	}

}
