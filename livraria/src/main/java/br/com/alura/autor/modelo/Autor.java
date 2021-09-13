package br.com.alura.autor.modelo;

import java.time.LocalDate;

public class Autor {

	private String nome;
	private String email;
	private LocalDate nascimento;
	
	public String toString() {
		return "Autor [nome=" + nome + ", email=" + email + ", nascimento=" + nascimento + "]";
	}
	
	public Autor() {}
	
	public Autor(String nome, String email, LocalDate nascimento) {
		super();
		this.nome = nome;
		this.email = email;
		this.nascimento = nascimento;
	}

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

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}
	
	
	
}
