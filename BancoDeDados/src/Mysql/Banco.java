package Mysql;

import javax.persistence.Entity ;
import javax.persistence.GeneratedValue ;
import javax.persistence.Id ;

@Entity
public class Banco {
	@Id
	@GeneratedValue
	private Long id ;
	private String nome ;
	private String email ;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}

