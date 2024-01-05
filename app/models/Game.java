package models;

import java.util.Date;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.data.validation.InPast;
import play.data.validation.Max;
import play.data.validation.Min;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Game extends Model {
	
	@Required
	public String nome;
	@Required
	public String genero;
	@Required
	public String desenvolvedor;
	@Required
	public String plataforma;
	@Required
	@Min(50)
	@Max(249)
	public String descricao;
	@Required
	public String nomeFoto;
	@Temporal(TemporalType.DATE)
	@Required
	public Date lancamento;
	@OneToMany
	@JoinColumn(name="idGame")
	public List<Critica> criticas;
}
