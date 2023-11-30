package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import play.data.validation.Max;
import play.data.validation.Min;
import play.data.validation.Required;
import play.db.jpa.Model;


@Entity
public class Critica extends Model {
	
	public String nomeUser;
	
	@Required
	public String plataforma;
	
	@Min(0)
	@Max(100)
	@Required
	public String nota;
	
	@Required
	public String analise;
	
	public String spoiler;
	public Date data = new Date();
	
	@ManyToOne
	@JoinColumn(name="idGame")
	public Game game;

}
