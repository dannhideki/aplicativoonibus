package facade;

import static spark.Spark.get;

import java.util.ArrayList;
import java.util.List;

import model.Itinerario;
import model.Onibus;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import com.db4o.ObjectSet;

import dao.OnibusDAO;
import enumerators.Zona;

public class Facade {
	private OnibusDAO onibusDAO;
	private List<Onibus> onibus;
	
	public Facade() {
		onibusDAO = new OnibusDAO();
		onibus = new ArrayList<Onibus>();
		
	}

	public void initializer() {

		Itinerario uiraItinerario = new Itinerario(209, "JD. UIRA / JOSE LONGO");
		Onibus uiraTerminal = new Onibus("JD. UIRA - TERMINAL CENTRAL (CIRCULAR NO BAIRRO) O.S.O. 039",Zona.LESTE, uiraItinerario);
		String rua = "AV. DAS CURRUIRAS - RUA DOS JABURUS - AV. MADRE TEREZA DE CALCUTA - R. HELIO SIQUEIRA PINTO - RUA JAIME PINTO MACHADO - AV. MADRE TEREZA DE CALCUTA - AV. DOS TANGARAS - AV. DAS SAIRAS - RUA SATURNO - RUA MERCURIO - RUA URANO - RUA CENTAURUS - PCA AQUILA - RUA ORION - AV. DOS ASTRONAUTAS - RUA ESPIRITO SANTO - RUA BAHIA - RUA TUPA - PCA CAP. PEDRO PINTO DA CUNHA - AV. SANTOS DUMONT - AV. SAMUEL WAINER - AV. DEP. BENEDITO MATARAZZO - AV. ENG FRANCISCO JOSE LONGO - PRACA CANDIDO DIAS CASTEJON - AVENIDA DR. JOAO GUILHERMINO - PRACA SAO JOAO BOSCO - RUA HUMAITA - PCA AFONSO PENA - RUA RUI DORIA - AV. SAO JOSE - TERMINAL CENTRAL";
		uiraItinerario.inserirRuas(rua);
		onibusDAO.salvarBus(uiraTerminal);

		Itinerario terminalUiraItiner = new Itinerario(209, "TERMINAL CENTRAL / JD. UIRA");
		Onibus terminalUira = new Onibus("JD. UIRA - TERMINAL CENTRAL (CIRCULAR NO BAIRRO) O.S.O. 039",Zona.LESTE,  terminalUiraItiner);
		String rua1 = "TERMINAL CENTRAL - AV. SAO JOSE - AV. MADRE THEREZA - RUA LUIZ JACINTO - RUA FRANCISCO BERLING - PCA CANDIDO DIAS CASTEJON - RUA PARAIBUNA - TREVO DO CTA - AV. DR. NELSON DAVILA - RUA TURQUIA - RUA ROMA - AV. SAMUEL WAINER - AV. SANTOS DUMONT - PCA CAP. PEDRO PINTO DA CUNHA - RUA CECI - VD. DA DUTRA - AV. DOS ASTRONAUTAS - TREVO DO INPE - RUA ORION - PCA AQUILA - RUA CENTAURUS - RUA NETUNO - RUA VENUS - RUA SATURNO - AV. DAS SAIRAS";
		terminalUiraItiner.inserirRuas(rua1);
		onibusDAO.salvarBus(terminalUira);

		Itinerario campoAlemaesItinerario = new Itinerario(323, "CAMPO DOS ALEMAES / TERMINAL CENTRAL");
		Onibus campoAlemaesTerminal = new Onibus("CAMPO DOS ALEMAES / TERMINAL CENTRAL (CIRCULAR NO CENTRO) O.S.O. 45",Zona.SUL, campoAlemaesItinerario);
		String rua2 = "AV. ADONIAS DA SILVA (PONTO INICIAL EM FRENTE AO NUMERO 831) – RUA JOSE LUIS DE SIQUEIRA (R. 77) – AV. DOS EVANGELICOS – AV. PADRE WILSON CUNHA (AV. 4) – RUA MALVINA BARBOSA DE ARAUJO (R. 55) – RUA SIMIAO FERREIRA DA MATA (R. 52) – AV. ANGELO BELMIRO PINTUS – AV. LENIN – AV. ADILSON JOSE DA CRUZ – AV. CIDADE JARDIM – AV. ANDROMEDA – AV. DR. SEBASTIAO HENRIQUE DA CUNHA PONTES – AVENIDA CIDADE JARDIM – RUA LUIZ GONZAGA SENDRETTI – RUA ANTONIO ALEIXO DA SILVA – VIADUTO TALIM – AVENIDA MARIO COVAS – AV. DR. JORGE ZARUR – AV. SAO JOAO – AV. MAJOR MIGUEL NAKED – AV. DR. EDUARDO CURY – AV. SAO JOAO – AV. MADRE PAULA DE SAO JOSE – AV. HEITOR VILLA LOBOS – AV. ENG. FRANCISCO JOSE LONGO – AV. DR. JOAO GUILHERMINO – PRACA SAO JOAO BOSCO – RUA HUMAITA – PCA AFONSO PENA – RUA DR. RUI DORIA – AV. SAO JOSE – TERMINAL CENTRAL";
		campoAlemaesItinerario.inserirRuas(rua2);
		onibusDAO.salvarBus(campoAlemaesTerminal);

		Itinerario terminalCampoAlemaesItiner = new Itinerario(323, "TERMINAL CENTRAL / CAMPO DOS ALEMAES");
		Onibus terminalCampo = new Onibus("CAMPO DOS ALEMAES / TERMINAL CENTRAL (CIRCULAR NO CENTRO) O.S.O. 45",Zona.SUL,  terminalCampoAlemaesItiner);
		String rua3 = "TERMINAL CENTRAL – AV. SAO JOSE – AV. MADRE THEREZA – RUA LUIZ JACINTO – PRACA ROTARY – RUA EUCLIDES MIRAGAIA – PRACA DR. MANOEL DE ABREU – AV. DR. ADHEMAR DE BARROS – RUA ENG. PRUDENTE MEIRELES DE MORAIS – AV. SAO JOAO – AV. MAJOR MIGUEL NAKED – AV. DR. EDUARDO CURY – BAIA DA AV. DR. JORGE ZARUR – AV. DR. JORGE ZARUR – AV. FLORESTAN FERNANDES (ANEL VIARIO) – ALCA DE ACESSO AO VIADUTO KANEBO - AV. DR. SEBASTIAO HENRIQUE DA CUNHA PONTES - AV. ANDROMEDA – AV. CIDADE JARDIM – AV. ADILSON JOSE DA CRUZ – AV. LENIN – AV. ANGELO BELMIRO PINTUS – RUA SIMIAO FERREIRA DA MATA (R.52) – RUA MALVINA BARBOSA DE ARAUJO (R.55) – AV. PADRE WILSON CUNHA – AV. DOS EVANGELICOS – RUA JOSE LUIS DE SIQUEIRA (R. 77) – AV. ADONIAS DA SILVA – ROTATORIA AV. DOS EVANGELICOS) – AV. ADONIAS DA SILVA – ROTATORIA AV. MARIA DE LOURDES MEDEIROS DE ASSIS – AV. ADONIAS DA SILVA (PONTO FINAL EM FRENTE AO NUMERO 831)";
		terminalCampoAlemaesItiner.inserirRuas(rua3);
		onibusDAO.salvarBus(terminalCampo);
		
		onibus = onibusDAO.buscarTodosItinerarios();

	}
	
	public void testePost() {
		Spark.post(new Route("/onibus/modopost/sentido/") {
            @Override
            public Object handle(Request request, Response response) {
            	response.header("Content-Type", "text/json; charset=UTF-8");
            	response.header("Access-Control-Allow-Origin", "*");
                String sentido = request.queryParams("sentido");		
                
                JSONArray jsonResult = new JSONArray();
				JSONObject jsonObj;
				try {
					for(Onibus  bus: onibus){
						if(bus.getItinerario().getSentido().equalsIgnoreCase(sentido)){

							jsonObj = new JSONObject();
							jsonObj.put("nome da linha", bus.getNomeLinha());
							jsonObj.put("zona", bus.getZona());
							jsonObj.put("numero da linha", bus.getItinerario().getNumeroLinha());
							jsonObj.put("sentido", bus.getItinerario().getSentido());
							jsonObj.put("ruas", bus.getItinerario().getRuas());
							jsonResult.put(jsonObj);
						}

					}
					response.status(200);

				} catch (JSONException e) {
					response.status(304);
					e.printStackTrace();
				}

				return jsonResult;
            }
        });
	}

	public String buscarItinerario(Itinerario itinerario) {
		ObjectSet<Object> busca = onibusDAO.buscarItinerario(itinerario);
		StringBuilder sb = new StringBuilder();
		if (!busca.isEmpty()) {
			System.out.println("Imprimindo busca da linha numero :" + itinerario.getNumeroLinha());
			for (Object o : busca) {
				sb.append(o);
			}
		} else {
			sb.append("O itinerario do sentido " + itinerario.getSentido() + " nao foi encontrado!");
		}
		return sb.toString();
	}

	public void getLinha() throws JSONException{
		
		get(new Route("/onibus/linha/:linha") {
			
			@Override
			public Object handle(Request request, Response response) {
				response.header("Content-Type", "text/json; charset=UTF-8");
				response.header("Access-Control-Allow-Origin", "*");
				int linha = Integer.parseInt(request.params(":linha"));
				JSONArray jsonResult = new JSONArray();
				try {
					for(Onibus bus: onibus){
						if(bus.getItinerario().getNumeroLinha() == linha){

							JSONObject jsonObj = new JSONObject();

							jsonObj.put("nome da linha", bus.getNomeLinha());
							jsonObj.put("zona", bus.getZona());
							jsonObj.put("numero da linha", bus.getItinerario().getNumeroLinha());
							jsonObj.put("sentido", bus.getItinerario().getSentido());
							jsonObj.put("ruas", bus.getItinerario().getRuas());
							jsonResult.put(jsonObj);
						}
					}

				} catch (JSONException e) {

					e.printStackTrace();
				}

				return jsonResult;
			}
		});
	}

	public void getZona() throws JSONException{
		get(new Route("/onibus/zona/:zona") {

			@Override
			public Object handle(Request request, Response response) {
				response.header("Content-Type", "text/json; charset=UTF-8");
				response.header("Access-Control-Allow-Origin", "*");
				String zona = request.params(":zona").toUpperCase();
				ObjectSet<Object> result = onibusDAO.buscarZona(zona);
				JSONArray jsonResult = new JSONArray();

				for(Object i: result){
					Onibus bus = (Onibus)i;
					JSONObject jsonObj = new JSONObject();

					try {
						jsonObj.put("nome da linha", bus.getNomeLinha());
						jsonObj.put("zona", bus.getZona());
						jsonObj.put("numero da linha", bus.getItinerario().getNumeroLinha());
						jsonObj.put("sentido", bus.getItinerario().getSentido());
						jsonObj.put("ruas", bus.getItinerario().getRuas());
						jsonResult.put(jsonObj);
					} catch (JSONException e) {

						e.printStackTrace();
					}

				}

				return jsonResult;
			}
		});
	}

	public void deletarRotaPorZona(){
		get(new Route("/onibus/deletar/linha/:linha") {
			@Override
			public Object handle(Request request, Response response) {
				response.header("Content-Type", "text/json; charset=UTF-8");
				response.header("Access-Control-Allow-Origin", "*");
				int linha = Integer.parseInt(request.params(":linha"));
				JSONArray jsonResult = new JSONArray();
				JSONObject jsonObj = new JSONObject();
				for(Onibus bus: onibus){
					if(bus.getItinerario().getNumeroLinha() == linha){
						try {
							jsonObj.put("linha", linha);
							jsonObj.put("nome da linha", bus.getNomeLinha());
							jsonObj.put("sentido", bus.getItinerario().getSentido());
							jsonObj.put("Deleted Success", true);
							jsonResult.put(jsonObj);
						} catch (JSONException e) {
							e.printStackTrace();
						}
						onibusDAO.deletarOnibus(linha);
					}
				}
				
				onibus = onibusDAO.buscarTodosItinerarios();
				return jsonResult;

			}
		});
	}

}
