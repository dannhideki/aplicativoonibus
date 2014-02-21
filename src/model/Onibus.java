package model;

public class Onibus {

	private String nomeLinha;
	private Itinerario itinerario;

	public Onibus(String nomeLinha, Itinerario itinerario) {
		this.nomeLinha = nomeLinha;
		this.itinerario = itinerario;
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

	@Override
	public String toString() {
		return "Onibus [ Linha=" + nomeLinha + ", " + itinerario + " ]";
	}

}
