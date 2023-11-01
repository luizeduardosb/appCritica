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
	
	public static void salvar(Game g, File foto) {

		
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
