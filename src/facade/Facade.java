package facade;

import model.Itinerario;
import model.Onibus;

import com.db4o.ObjectSet;

import dao.OnibusDAO;

public class Facade {
	private OnibusDAO onibusDAO;

	public Facade() {
		onibusDAO = new OnibusDAO();
	}

	public void initializer() {

		Itinerario uiraItinerario = new Itinerario(209, "JD. UIRA / JOSE LONGO");
		Onibus uiraTerminal = new Onibus("JD. UIRA - TERMINAL CENTRAL (CIRCULAR NO BAIRRO) O.S.O. 039", uiraItinerario);
		String rua = "AV. DAS CURRUIRAS - RUA DOS JABURUS - AV. MADRE TEREZA DE CALCUTA - R. HELIO SIQUEIRA PINTO - RUA JAIME PINTO MACHADO - AV. MADRE TEREZA DE CALCUTA - AV. DOS TANGARAS - AV. DAS SAIRAS - RUA SATURNO - RUA MERCURIO - RUA URANO - RUA CENTAURUS - PCA AQUILA - RUA ORION - AV. DOS ASTRONAUTAS - RUA ESPIRITO SANTO - RUA BAHIA - RUA TUPA - PCA CAP. PEDRO PINTO DA CUNHA - AV. SANTOS DUMONT - AV. SAMUEL WAINER - AV. DEP. BENEDITO MATARAZZO - AV. ENG¡ FRANCISCO JOSE LONGO - PRACA CANDIDO DIAS CASTEJON - AVENIDA DR. JOAO GUILHERMINO - PRACA SAO JOAO BOSCO - RUA HUMAITA Ð PCA AFONSO PENA - RUA RUI DORIA Ð AV. SAO JOSE - TERMINAL CENTRAL";
		uiraItinerario.inserirRuas(rua);
		onibusDAO.salvarBus(uiraTerminal);

		Itinerario terminalUiraItiner = new Itinerario(209, "TERMINAL CENTRAL / JD. UIRA");
		Onibus terminalUira = new Onibus("JD. UIRA - TERMINAL CENTRAL (CIRCULAR NO BAIRRO) O.S.O. 039", terminalUiraItiner);
		String rua1 = "TERMINAL CENTRAL - AV. SAO JOSE - AV. MADRE THEREZA - RUA LUIZ JACINTO - RUA FRANCISCO BERLING - PCA CANDIDO DIAS CASTEJON - RUA PARAIBUNA - TREVO DO CTA - AV. DR. NELSON DAVILA - RUA TURQUIA - RUA ROMA - AV. SAMUEL WAINER - AV. SANTOS DUMONT - PCA CAP. PEDRO PINTO DA CUNHA - RUA CECI - VD. DA DUTRA - AV. DOS ASTRONAUTAS - TREVO DO INPE - RUA ORION - PCA AQUILA - RUA CENTAURUS - RUA NETUNO - RUA VENUS - RUA SATURNO - AV. DAS SAIRAS";
		terminalUiraItiner.inserirRuas(rua1);
		onibusDAO.salvarBus(terminalUira);

	}

	public void buscarItinerario(Itinerario itinerario) {
		ObjectSet<Object> busca = onibusDAO.buscarItinerario(itinerario);
		if (!busca.isEmpty()) {
			System.out.println("Imprimindo busca da linha numero :" + itinerario.getNumeroLinha());
			for (Object o : busca) {
				System.out.println(o);
			}
		} else {
			System.out.println("O itinerario do sentido " + itinerario.getSentido() + " nao foi encontrado!");
		}
		System.out.println();
	}

	public void deletarItinerario(Itinerario itinerario) {
		System.out.println("Removendo itinerario do sentido : " + itinerario.getSentido());
		onibusDAO.deletarOnibus(itinerario);
		System.out.println("Buscando na lista o itinerario do sentido : " + itinerario.getSentido());
		buscarItinerario(itinerario);
	}
}
