package br.com.unipe;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.unipe.http.Estabelecimento;
import br.com.unipe.http.EstabelecimentoPrato;
import br.com.unipe.util.Constantes;

@ManagedBean(name = "estabelecimentoBeans")
@ViewScoped
public class EstabelecimentoBean {

	public EstabelecimentoBean(){}
	
	static Client c = Client.create();

	private static Gson gson = new Gson();
	private List<Estabelecimento> listaEstabelecimentos;
	private static Estabelecimento estabelecimento;
	private static EstabelecimentoPrato estabelecimentoPrato;
	
	@PostConstruct
	public void init() {
		estabelicimentosREST();
	}
	
	public void voltarIndex(){
		try {
			FacesContext.getCurrentInstance().getExternalContext()
			.redirect(getContextPath() + "/restrito/index.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void estabelicimentosREST(){
		WebResource webResource = c.resource(Constantes.REST_GET_ESTABELECIMENTOS);
		String json = webResource.get(String.class);
		listaEstabelecimentos = gson.fromJson(json, 
				new TypeToken<List<Estabelecimento>>(){}.getType());
	}
	
	public void preparaVisualizacao(int id) {
		try {
			WebResource webResource = c.resource(String.format(Constantes.REST_GET_ESTABELECIMENTO_ID , id));
			String json = webResource.get(String.class);
			estabelecimentoPrato = gson.fromJson(json, EstabelecimentoPrato.class);
			FacesContext.getCurrentInstance().getExternalContext()
			.redirect(getContextPath() + "/restrito/visualizar.xhtml");
		} catch (IOException e) {
			System.out.println("Não foi possível visualizar");
			e.printStackTrace();
		}
		
	}
	
	public void preparaEdicao(int id) {
		try {
			WebResource webResource = c.resource(String.format(Constantes.REST_GET_ESTABELECIMENTO_ID , id));
			String json = webResource.get(String.class);
			estabelecimento = gson.fromJson(json,Estabelecimento.class);
			FacesContext.getCurrentInstance().getExternalContext()
			.redirect(getContextPath() + "/restrito/edicao.xhtml");
		} catch (IOException e) {
			System.out.println("Não foi possível visualizar");
			e.printStackTrace();
		}
		
	}
	
	public void atualizar(){
		try {
			WebResource webResource = c.resource(Constantes.REST_PUT_ATUALIZAR);
			ClientResponse response = webResource.type("application/json")
					   .put(ClientResponse.class, gson.toJson(estabelecimento));
			FacesContext.getCurrentInstance().getExternalContext()
			.redirect(getContextPath() + "/restrito/index.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void preparaCadastrar(){
		try {
			estabelecimento = new Estabelecimento();
			FacesContext.getCurrentInstance().getExternalContext()
			.redirect(getContextPath() + "/restrito/cadastrar.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void cadastrar(){
		try {
			WebResource webResource = c.resource(Constantes.REST_POST_CADASTRAR);
			ClientResponse response = webResource.type("application/json")
					   .post(ClientResponse.class, gson.toJson(estabelecimento));
			FacesContext.getCurrentInstance().getExternalContext()
			.redirect(getContextPath() + "/restrito/index.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(int id){
		try {
			WebResource webResource = c.resource(String.format(Constantes.REST_DELTE_EXCLUIR, id));
			ClientResponse response = webResource.type("application/json")
					   .delete(ClientResponse.class);
			FacesContext.getCurrentInstance().getExternalContext()
			.redirect(getContextPath() + "/restrito/index.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Estabelecimento> getListaEstabelecimentos() {
		return listaEstabelecimentos;
	}

	public void setListaEstabelecimentos(List<Estabelecimento> listaEstabelecimentos) {
		this.listaEstabelecimentos = listaEstabelecimentos;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public EstabelecimentoPrato getEstabelecimentoPrato() {
		return estabelecimentoPrato;
	}

	public void setEstabelecimentoPrato(EstabelecimentoPrato estabelecimentoPrato) {
		this.estabelecimentoPrato = estabelecimentoPrato;
	}

	protected String getContextPath() {
		return FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
	}
	
}
