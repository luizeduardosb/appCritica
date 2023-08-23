package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;


@Entity
public class Critica extends Model {
	
	public String usuario;
	public String plataforma;
	public String nota;
	public String analise;
	public String spoiler;

	@ManyToOne
	public Game game;

}
