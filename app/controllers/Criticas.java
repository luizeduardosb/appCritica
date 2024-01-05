package controllers;

import java.util.Date;
import java.util.List;

import javax.persistence.Cache;

import models.Critica;
import models.Game;
import models.Usuario;
import play.data.validation.Valid;
import play.mvc.Controller;
import play.mvc.With;

@With(Seguranca.class)
public class Criticas extends Controller {

	public static void form() {
		List<Game> games = Game.findAll();
		List<Usuario> usuarios = Usuario.findAll();
		render(games, usuarios);
	}

	public static void salvar(@Valid Critica c) {
		if (validation.hasErrors()) {
			errosValidacao();
		}

		c.nomeUser = session.get("user");
		
		c.save();
		flash.success("Sua crítica foi enviada com sucesso.");
		Long gameId = c.game.id;
		Games.detalhar(gameId);
	}

	private static void errosValidacao() {
		params.flash();
		validation.keep();
		flash.error("Não sou especialista, "
				+ "mas creio que há um erro "
				+ "em seu formulário... "
				+ "Corrija e tente novamente");
		form();
	}

	public static void listar() {
		String busca = params.get("busca");
		List<Critica> lista = Critica.findAll();

		if (busca == null || busca.isEmpty()) {
			lista = Critica.findAll();
		} else {
			lista = Critica.find("lower(spoiler) like ?1", "%" + busca.toLowerCase() + "%").fetch();
		}

		render(lista, busca);

	}

	public static void editar(long id) {
		Critica c = Critica.findById(id);
		List<Game> games = Game.findAll();
		List<Usuario> usuarios = Usuario.findAll();

		renderTemplate("Criticas/form.html", c, games, usuarios);
	}

}
