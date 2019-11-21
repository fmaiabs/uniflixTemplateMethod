package br.unifor.uniflix.controller;


import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public abstract class JsonAdapter <T> { //Comentário do adapter original - T é genérico
	abstract T adapter (JSONObject json); //Comentário do adapter original - vai chamar o outro json lá do pegafilmeadapter
	
	public List <T> adapterJsonArray (JSONArray array) { //transforma tudo em genérico pra não correr o for em cada classadapter
		List<T> adaptedList = new ArrayList<T>();
		
		for (int i = 0; i < array.length(); i++) {
            JSONObject jsonObject = array.getJSONObject(i);
        	T object = adapter(jsonObject);
        	adaptedList.add(object);//o pegafilme chama generico e corre filme assim como o tvshow
        }
		
		return adaptedList;
	}
	
		
	
}
//adapter.adapterJsonArray(JSONArray)