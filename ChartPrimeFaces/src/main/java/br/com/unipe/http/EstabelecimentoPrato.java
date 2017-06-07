package br.com.unipe.http;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class EstabelecimentoPrato {

	private Estabelecimento estabelecimento;
	private List<Prato> pratos;
	
	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}
	
	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
	
	public List<Prato> getPrato() {
		return pratos;
	}

	public void setPrato(List<Prato> pratos) {
		this.pratos = pratos;
	}
}