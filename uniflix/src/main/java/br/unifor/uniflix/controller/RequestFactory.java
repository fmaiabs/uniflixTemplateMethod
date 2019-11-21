package br.unifor.uniflix.controller;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class RequestFactory {

		public Call requestCreate (String path) {
			OkHttpClient client = new OkHttpClient();
			Request request = new Request.Builder()
					.url("https://api.themoviedb.org/3" + path + "?api_key=4cb2552f1fb1296c1aba5bc07bebab75")
					.build();
			return client.newCall(request);
		}
}
