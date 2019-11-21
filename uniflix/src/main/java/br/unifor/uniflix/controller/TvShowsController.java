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
import br.unifor.uniflix.model.TvShow;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

@Path("/tvshows")
public class TvShowsController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response airingToday() throws IOException {
    /*    OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.themoviedb.org/3" + "/tv/airing_today?api_key=<API-KEY-AQUI>")
                .build();
*/
        RequestFactory filme = new RequestFactory();
    	Call call = filme.requestCreate("/tv/airing_today");
    	
     //   Call call = client.newCall(request);

        okhttp3.Response response = call.execute();
        if (response.isSuccessful()) {
            JSONObject jsonResponse = new  JSONObject(response.body().string());
            JSONArray result = jsonResponse.getJSONArray("results");
            List<Filme> filmes = new ArrayList<>();
           
            for (int i = 0; i < result.length(); ++i) {
                JSONObject movieJson = result.getJSONObject(i);
            TvShowsAdapter programaDoTvShow = new TvShowsAdapter();
            TvShow programa = programaDoTvShow.adapter(jsonResponse);
            
            /*    List<Filme> filmes = new ArrayList<>();
            	for (int i = 0; i < result.length(); ++i) {
                JSONObject movieJson = result.getJSONObject(i);
                PegaFilmeAdapter filmedopegafilme = new PegaFilmeAdapter();
            	Filme outrofilme = filmedopegafilme.adapter(movieJson);
            	filmes.add(outrofilme);*/
            return Response.ok("filmes").build();
        }
        return Response.serverError().build();
    }
		return null;
   }
}
