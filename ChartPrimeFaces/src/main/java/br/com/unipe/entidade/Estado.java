package br.com.unipe.entidade;

public class Estado {

	private String estado;

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Estado(String estado){
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		return estado;
	}
}
