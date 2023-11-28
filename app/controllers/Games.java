package controllers;

import java.io.File;
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
		if (idCritica != null) {
			Critica c = Critica.findById(idCritica);
			g.criticas.add(c);
		}

		g.nomeFoto = foto.getName();
		g.save();

		new File(".\\appCritica\\\\uploads\\" + g.id).mkdirs();

		File dest = new File(".\\appCritica\\uploads\\" + g.id + "\\" + foto.getName());
		if (dest.exists()) {
			dest.delete();
		}

		foto.renameTo(dest);

		home();
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

	/*
	 * <<INCOMPLETO>>
	 * 
	 * public static void notaMedia(Critica c) { 
	 * List<Critica> criticas = Critica.findAll();
	 * 
	 * int conv = Integer.parseInt(c.nota);
	 * 
	 * render(); }
	 */
}
