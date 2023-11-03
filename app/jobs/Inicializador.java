package jobs;

import java.util.Date;

import models.Critica;
import models.Game;
import models.Usuario;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Inicializador extends Job {

	@Override
	public void doJob() throws Exception {
		if (Game.count() == 0) {
			Game gta = new Game();
			gta.nome = "Grand Theft Auto V";
			gta.genero = "Mundo aberto";
			gta.desenvolvedor = "Rockstar Games";
			gta.plataforma = "Windows, Playstation, Xbox";
			gta.descricao = "Um tratante inexperiente, um ladrão de bancos aposentado e um psicopata aterrorizante "
					+ "se envolvem com algumas das figuras mais assustadoras e problemáticas do submundo do crime, "
					+ "do governo dos EUA e da indústria do entretenimento.";
			gta.lancamento = new Date();
			gta.save();

			Game detroit = new Game();
			detroit.nome = "Detroit: Become Human";
			detroit.genero = "Ação e Aventura";
			detroit.desenvolvedor = "Quantic Dream";
			detroit.plataforma = "Windows, Playstation";
			detroit.descricao = "Detroit 2038. A tecnologia evoluiu a um ponto onde, assim como humanos, há androides "
					+ "por toda a parte. Eles falam, se movem e se comportam como humanos, mas são apenas máquinas para servi-los.";
			detroit.lancamento = new Date();
			detroit.save();
		}

		if (Critica.count() == 0) {
			Critica um = new Critica();
			um.usuario = "dudu";
			um.plataforma = "Windows";
			um.nota = "99";
			um.analise = "Jogo incrivel, muito bom! Um dos melhores "
					+ "jogos que já joguei em toda minha vida! Imersão "
					+ "de outro planeta, sentimentos que nunca vi antes";
			um.spoiler = "nao";
			um.save();
			
			Critica dois = new Critica();
			dois.usuario = "leco";
			dois.plataforma = "Xbox";
			dois.nota = "92";
			dois.analise = "Massinha, mas bem mais ou menos, histórinha chata, o cara lá morre";
			dois.spoiler = "sim";
			dois.save();
		}
		
		if (Usuario.count() == 0) {
			Usuario dudu = new Usuario();
			dudu.usuario = "@dudu";
			dudu.senha = "dudu";
			dudu.perfil = "admin";
			dudu.save();
			
			Usuario danilo = new Usuario();
			danilo.usuario = "@danilo";
			danilo.senha = "danilo";
			danilo.perfil = "admin";
			danilo.save();
			
			Usuario lukita = new Usuario();
			lukita.usuario = "@lukita";
			lukita.senha = "lukita";
			lukita.perfil = "comum";
			lukita.save();
			
		}
	}

}
