package br.edu.infnet.bemseguro.domain.model;

public class Segurado {

	private String nome;
	private String cpfCnpj;
	private String email;
	
	public Segurado(String nome, String cpfCnpj, String email) {
		this.nome = nome;
		this.cpfCnpj = cpfCnpj;
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.nome);
		sb.append(';');
		sb.append(this.cpfCnpj);
		sb.append(';');
		sb.append(this.email);
		
		return sb.toString();
	}
}