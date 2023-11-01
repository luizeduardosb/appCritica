package models;

import javax.persistence.Entity;

import groovyjarjarpicocli.CommandLine.IFactory;
import play.db.jpa.Model;

@Entity
public class Usuario extends Model {
	public String usuario;
	public String senha;
	public String perfil;
}
