package controllers;


import java.io.File;
import java.util.List;

import models.Critica;
import models.Game;
import play.mvc.Controller;

public class Games extends Controller {
	
	public static void form() {
		render();
	}
	
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
	
	public static void editar(long id) {
		Game g = Game.findById(id);
		List<Critica> criticas = Critica.findAll();
		
		renderTemplate("Games/form.html", g, criticas);
	}
	
	public static void deletar(long id) {
		Game g = Game.findById(id);
		g.delete();
		
		
		home();
	}
	
	public static void removerCritica(Long idGame, Long idCritica) {
		Game g = Game.findById(idGame);
		Critica c = Critica.findById(idCritica);
		
		g.criticas.remove(c);
		g.save();
		editar(g.id);
	}
}
