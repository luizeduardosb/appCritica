package models;

import javax.persistence.Entity;

import play.db.jpa.Model;


@Entity
public class Critica extends Model {
	
	public String usuario;
	public String game;
	public String plataforma;
	public String nota;
	public String analise;
	public String spoiler;
	

}
