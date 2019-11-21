package br.unifor.uniflix.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import br.unifor.uniflix.model.Filme;
import okhttp3.Call;

@Path("/filmes")
public class FilmesController {

  //Factory ok 
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response popularMovies() throws IOException {

    	Facade facade = new Facade();
    	List<Filme> variosfilmes = facade.popularMovies();
    	
    	return Response.ok (variosfilmes).build();
    }
}
    /*	RequestFactory filme = new RequestFactory();
    	Call call = filme.requestCreate("/movie/popular");
        
        okhttp3.Response response = call.execute();
        if (response.isSuccessful()) {
            JSONObject jsonResponse = new  JSONObject(response.body().string());
            JSONArray result = jsonResponse.getJSONArray("results");
            List<Filme> filmes = new ArrayList<>();
            for (int i = 0; i < result.length(); ++i) {
                JSONObject movieJson = result.getJSONObject(i);
                PegaFilmeAdapter filmedopegafilme = new PegaFilmeAdapter();
            	Filme outrofilme = filmedopegafilme.adapter(movieJson);
            	filmes.add(outrofilme);
            }
            return Response.ok(filmes).build();
        }
        return Response.serverError().build();
    }*/
