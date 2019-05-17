package aep;

import java.util.UUID;

public abstract class Pessoa {
	protected UUID id;
	protected String nome;
	
	public String getNome() {
		return nome;
	}
	
	public UUID getId() {
		return id;
	}
	
	public Pessoa(String nome) {
		this.nome = nome;
	}
	
	public Pessoa(UUID id, String nome) {
		this.id = id;
		this.nome = nome;
	}
}
