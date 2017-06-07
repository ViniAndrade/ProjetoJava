package br.com.unipe.http;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Prato{

	private int id;

	private String nome;

	private double valor;

	public Prato() {
	}

	public Prato(int id, String nome, double valor) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}