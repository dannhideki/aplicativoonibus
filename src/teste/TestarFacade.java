package teste;

import model.Itinerario;
import facade.Facade;

public class TestarFacade {

	public static void main(String[] args) {
		Facade facade = new Facade();
		facade.initializer();

		Itinerario teste1 = new Itinerario(209, "JD. UIRA / JOSE LONGO");
		Itinerario teste2 = new Itinerario(209, "TERMINAL CENTRAL / JD. UIRA");

		facade.buscarItinerario(teste1);
		facade.buscarItinerario(teste2);

		facade.deletarItinerario(teste1);
	}

}
