package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import groovyjarjarpicocli.CommandLine.IFactory;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Usuario extends Model {
	
	@Required
	public String nome;
	@Required
	public String usuario;
	@Required
	public String senha;
	public String perfil;
	
	public String cep;
	public String uf;
	public String cidade;
}


