package dao;

import model.Itinerario;
import model.Onibus;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

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

	public void deletarOnibus(Itinerario itinerario) {
		ObjectSet<Object> remover = buscarItinerario(itinerario);
		if (!remover.isEmpty()) {
			Onibus bus = (Onibus) remover.next();
			onibus.delete(bus);
		}
	}

}
