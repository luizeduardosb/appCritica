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

import play.db.jpa.Model;

@Entity
public class Game extends Model {
	
	public String nome;
	public String genero;
	public String desenvolvedor;
	public String plataforma;
	public String descricao;
	public String nomeFoto;
	
	
	@Temporal(TemporalType.DATE)
	public Date lancamento;
	
	@OneToMany
	@JoinColumn(name="idGame")
	public List<Critica> criticas;
	
	

}
