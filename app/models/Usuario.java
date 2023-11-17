package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import groovyjarjarpicocli.CommandLine.IFactory;
import play.db.jpa.Model;

@Entity
public class Usuario extends Model {
	public String nome;
	public String usuario;
	public String senha;
	public String perfil;
}


