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
					+ "se envolvem com algumas das figuras mais assustadoras e problemáticas do submundo do crime, ";
			gta.lancamento = new Date();
			gta.nomeFoto = "../1/gtav.webp";
			gta.save();

			Game eaSports = new Game();
			eaSports.nome = "EA Sports FC 24";
			eaSports.genero = "Esporte, Jogo de simulação";
			eaSports.desenvolvedor = "EA Romania, EA Vancouver";
			eaSports.plataforma = "Windows, Playstation, Xbox, Switch";
			eaSports.descricao = "EA SPORTS FC 24 leva você para mais perto do futebol do que nunca, impulsionado por "
					+ "três tecnologias que entregam realismo em todas as partidas.";
			eaSports.lancamento = new Date();
			eaSports.nomeFoto = "../2/EaSportsFc.jfif";
			eaSports.save();

			Game detroit = new Game();
			detroit.nome = "Detroit: Become Human";
			detroit.genero = "Ação e Aventura";
			detroit.desenvolvedor = "Quantic Dream";
			detroit.plataforma = "Windows, Playstation";
			detroit.descricao = "Detroit 2038. A tecnologia evoluiu a um ponto onde, assim como humanos, há androides "
					+ "por toda a parte. Eles falam, se movem e se comportam como humanos, mas são apenas máquinas para servi-los.";
			detroit.lancamento = new Date();
			detroit.nomeFoto = "../3/detroit.jfif";
			detroit.save();

			Game theLast = new Game();
			theLast.nome = "The Last of Us Part I";
			theLast.genero = "Ação e Aventura, Tiro";
			theLast.desenvolvedor = "Naughty Dog, Iron Galaxy Studios";
			theLast.plataforma = "Playstation, Windows";
			theLast.descricao = "Em uma civilização devastada, em que infectados e sobreviventes veteranos estão à solta, Joel, "
					+ "um protagonista abatido, é contratado para tirar uma garota de 14 anos, Ellie, de uma zona de quarentena militar.";
			theLast.lancamento = new Date();
			theLast.nomeFoto = "../4/theLastOfUs-I.webp";
			theLast.save();
		}

		if (Critica.count() == 0) {
			Critica um = new Critica();
			um.nomeUser = "@njr10";
			um.plataforma = "Windows";
			um.nota = "99";
			um.analise = "Jogo incrivel, muito bom! Um dos melhores "
					+ "jogos que já joguei em toda minha vida! Imersão "
					+ "de outro planeta, sentimentos que nunca vi antes";
			um.spoiler = "nao";
			um.save();

			Critica dois = new Critica();
			dois.nomeUser = "@chico_moedas";
			dois.plataforma = "Xbox";
			dois.nota = "92";
			dois.analise = "Massinha, mas bem mais ou menos, histórinha chata, o cara lá morre";
			dois.spoiler = "sim";
			dois.save();
		}

		if (Usuario.count() == 0) {
			Usuario dudu = new Usuario();
			dudu.nome = "Luiz Eduardo";
			dudu.usuario = "@dudu";
			dudu.senha = "dudu";
			dudu.perfil = "admin";
			dudu.save();

			Usuario danilo = new Usuario();
			danilo.nome = "Daniel da Madeira";
			danilo.usuario = "@danilo";
			danilo.senha = "danilo";
			danilo.perfil = "admin";
			danilo.save();

			Usuario lukita = new Usuario();
			lukita.nome = "Lukita da galera";
			lukita.usuario = "@lukita";
			lukita.senha = "lukita";
			lukita.perfil = "comum";
			lukita.save();

		}
	}
}
