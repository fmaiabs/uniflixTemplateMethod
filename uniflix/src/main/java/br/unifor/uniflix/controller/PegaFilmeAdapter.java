package br.unifor.uniflix.controller;
import org.json.JSONObject;
import br.unifor.uniflix.model.Filme;

public class PegaFilmeAdapter extends JsonAdapter<Filme> {

	Filme adapter (JSONObject json) {
	    Filme filme = new Filme();
	    filme.setTitulo(json.getString("title"));
	    filme.setSinopse(json.getString("overview"));
	    filme.setAdulto(json.getBoolean("adult"));
	    filme.setNota(json.getDouble("vote_average"));
	    return filme;
	}	
}
