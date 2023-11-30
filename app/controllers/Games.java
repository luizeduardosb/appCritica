package controllers;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import annotations.Administrador;
import models.Critica;
import models.Game;
import play.mvc.Controller;
import play.mvc.With;

@With(Seguranca.class)
public class Games extends Controller {

	@Administrador
	public static void form() {
		render();
	}

	@Administrador
	public static void salvar(Game g, File foto, Long idCritica) {
		if (validation.hasErrors()) {
			errosValidacao();
		}
		
		if (idCritica != null) {
			Critica c = Critica.findById(idCritica);
			g.criticas.add(c);
		}

		g.nomeFoto = foto.getName();
		flash.success("Comemora, nação! O game foi adicionado com sucesso.");
		g.save();

		new File(".\\appCritica\\\\uploads\\" + g.id).mkdirs();

		File dest = new File(".\\appCritica\\uploads\\" + g.id + "\\" + foto.getName());
		if (dest.exists()) {
			dest.delete();
		}

		foto.renameTo(dest);
		home();
	}
	
	private static void errosValidacao() {
		params.flash();
		validation.keep();
		flash.error("Não sou especialista, mas creio que há um erro em seu formulário... Corrija e tente novamente");
		form();
	}

	public static void home() {
		List<Game> lista = Game.findAll();
		List<Critica> criticas = Critica.findAll();

		renderTemplate("Games/home.html", lista, criticas);
	}

	public static void detalhar(Long id) {
		Game game = Game.findById(id);
		List<Critica> criticas = Critica.findAll();

		renderTemplate("Games/detalhar.html", game, criticas);
	}

	@Administrador
	public static void editar(long id) {
		Game g = Game.findById(id);
		List<Critica> criticas = Critica.findAll();

		renderTemplate("Games/form.html", g, criticas);
	}

	@Administrador
	public static void deletar(long id) {
		Game g = Game.findById(id);
		g.delete();

		home();
	}

	@Administrador
	public static void removerCritica(Long idGame, Long idCritica) {
		Game g = Game.findById(idGame);
		Critica c = Critica.findById(idCritica);

		g.criticas.remove(c);
		g.save();
		editar(g.id);
	}

	public static int notaMedia(Long gameId) {
		Game game = Game.findById(gameId);

		if (game != null && game.criticas != null && !game.criticas.isEmpty()) {
			double somaNotas = 0;

			for (Critica critica : game.criticas) {
				somaNotas += Integer.parseInt(critica.nota);
			}

			return (int) (somaNotas / game.criticas.size());
		} else {
			return 0;
		}
	}
}
