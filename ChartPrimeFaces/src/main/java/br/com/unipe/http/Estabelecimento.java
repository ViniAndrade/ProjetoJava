package br.com.unipe.http;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Estabelecimento{

	private int id;

	private String cnpj;

	private String nome;
	
	private String senha;

	public Estabelecimento() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}