package br.unifor.uniflix.controller;

import org.json.JSONObject;

import br.unifor.uniflix.model.Filme;
import br.unifor.uniflix.model.TvShow;

public class TvShowsAdapter extends JsonAdapter<TvShow> {
	public TvShow adapter(JSONObject json) {
		// TODO Auto-generated method stub
		
	    TvShow programa = new TvShow();
	    programa.setName(json.getString("name"));
	    programa.setPopularity(json.getDouble("popularity"));
	    programa.setOrigin_country(json.getString("origincountry"));
	    
	    return programa;
		
	}
}