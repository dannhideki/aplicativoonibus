package model;

import enumerators.Zona;

public class Onibus {

	private String nomeLinha;
	private Itinerario itinerario;
	private Zona zona;

	public Onibus(String nomeLinha,Zona zona, Itinerario itinerario) {
		this.nomeLinha = nomeLinha;
		this.itinerario = itinerario;
		this.zona = zona;
	}

	public String getNomeLinha() {
		return nomeLinha;
	}

	public void setNomeLinha(String nomeLinha) {
		this.nomeLinha = nomeLinha;
	}

	public Itinerario getItinerario() {
		return itinerario;
	}

	public void setItinerario(Itinerario itinerario) {
		this.itinerario = itinerario;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	@Override
	public String toString() {
		return "Onibus [ Linha=" + nomeLinha + ", Zona = "+zona +" , "+ itinerario + " ]";
	}
}
