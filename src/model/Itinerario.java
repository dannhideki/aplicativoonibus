package model;

import java.util.ArrayList;
import java.util.List;

public class Itinerario {

	private List<String> ruas;
	private int numeroLinha;
	private String sentido;

	public Itinerario(int numeroLinha, String sentido) {
		ruas = new ArrayList<String>();
		this.numeroLinha = numeroLinha;
		this.sentido = sentido;
	}

	public void inserirRuas(String rua) {
		String[] ruas = rua.split("-");
		for (String r : ruas) {
			this.ruas.add(r);
		}
	}

	public int getNumeroLinha() {
		return numeroLinha;
	}

	public void setNumeroLinha(int numeroLinha) {
		this.numeroLinha = numeroLinha;
	}

	public List<String> getRuas() {
		return ruas;
	}

	public String getSentido() {
		return sentido;
	}

	public void setSentido(String sentido) {
		this.sentido = sentido;
	}

	@Override
	public String toString() {
		return "Itinerario [ruas = " + ruas + ", Numero da Linha = " + numeroLinha + ", Sentido = " + sentido + "]";
	}

}
