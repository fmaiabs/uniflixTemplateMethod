package br.unifor.uniflix.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import br.unifor.uniflix.model.Filme;
import br.unifor.uniflix.model.TvShow;
import okhttp3.Call;

public class Facade {
	public List <Filme> popularMovies() throws IOException {

    	RequestFactory filme = new RequestFactory();
    	Call call = filme.requestCreate("/movie/popular");
        
        okhttp3.Response response = call.execute();
        if (response.isSuccessful()) {
            JSONObject jsonResponse = new  JSONObject(response.body().string());
            JSONArray result = jsonResponse.getJSONArray("results");
            PegaFilmeAdapter filmedopegafilme = new PegaFilmeAdapter();
            List<Filme> filmes = filmedopegafilme.adapterJsonArray(result);
          //era o for  
            return filmes;
        }
        return new ArrayList<>();
    }

//fazer o de tvshow depois	
	
	public List <Filme> airingToday() throws IOException {
	  
	        RequestFactory filme = new RequestFactory();
	    	Call call = filme.requestCreate("/tv/airing_today");
	    	
	        okhttp3.Response response = call.execute();
	        if (response.isSuccessful()) {
	            JSONObject jsonResponse = new  JSONObject(response.body().string());
	            JSONArray result = jsonResponse.getJSONArray("results");
	            List<Filme> filmes = new ArrayList<>();
	           
	            /*for (int i = 0; i < result.length(); ++i) {
	                JSONObject movieJson = result.getJSONObject(i);
	            TvShowsAdapter programaDoTvShow = new TvShowsAdapter();
	            TvShow programa = programaDoTvShow.adapter(jsonResponse);
	       */
	       
	            return filmes;
	            }	
	      
	     	
	        return new ArrayList<>();	    
		}	
}