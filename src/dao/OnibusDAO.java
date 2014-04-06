package dao;

import model.Itinerario;
import model.Onibus;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

import enumerators.Zona;

public class OnibusDAO {

	private ObjectContainer onibus;

	public OnibusDAO() {
		onibus = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bus.db4o");
	}

	public void salvarBus(Onibus bus) {
		onibus.store(bus);
	}

	public ObjectSet<Object> buscarItinerario(Itinerario itinerario) {
		Query query = onibus.query();
		query.descend("itinerario").constrain(itinerario);
		ObjectSet<Object> result = query.execute();
		return result;
	}
	
	public ObjectSet<Onibus> buscarTodosItinerarios(){
		ObjectSet<Onibus> resultado = onibus.query(Onibus.class);
		return resultado;
	}

	public void deletarOnibus(int linha) {
		ObjectSet<Onibus> remover = buscarLinha(linha);
		if (!remover.isEmpty()) {
			Onibus bus = (Onibus) remover.next();
			onibus.delete(bus);
		}
	}
	
	public ObjectSet<Object> buscarSentido(String sentido) {
		Query query = onibus.query();
		query.descend("sentido").constrain(sentido);
		ObjectSet<Object> result = query.execute();
		return result;
	}
	
	public ObjectSet<Onibus> buscarLinha(int linha) {
		Query query = onibus.query();
		query.descend("linha").constrain(linha);
		ObjectSet<Onibus> result = query.execute();
		return result;
	}
	
	public ObjectSet<Object> buscarZona(String zona){
		Query query = onibus.query();
		query.descend("zona").constrain(Zona.convertStringToZona(zona));
		ObjectSet<Object> result = query.execute();
		return result;
	}

}
