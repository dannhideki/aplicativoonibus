package teste;

import org.json.JSONException;

import facade.Facade;
import static spark.Spark.*;
public class TestarFacade {

	public static void main(String[] args) {
		setPort(8000);
		Facade facade = new Facade();
		facade.initializer();
		try {
			facade.testeAjax();
			facade.getZona();
			facade.getLinha();
			facade.getSentido();
			//facade.getItinerario();
			facade.deletarRotaPorZona();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

}
