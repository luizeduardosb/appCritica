package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import groovyjarjarpicocli.CommandLine.IFactory;
import net.sf.oval.constraint.MinSize;
import play.data.validation.Max;
import play.data.validation.MaxSize;
import play.data.validation.Min;
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
	
	@Required
	@MinSize(8)
	@MaxSize(8)
	public String cep;
	@Required
	public String uf;
	@Required
	public String cidade;
}


