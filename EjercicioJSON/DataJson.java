package main;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataJson {
	
	
	public static void serializar(Producto p) {
		// instanciar un objeto de tipo ObjectMapper
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonText = "";
		try {
			jsonText = objectMapper.writeValueAsString(p);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(jsonText);
	}

	public static void parsear(String json) {
		ObjectMapper objectMapper = new ObjectMapper();
		Producto p = null;
		try {
			p = objectMapper.readValue(json, Producto.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(p);
		
	}

	public static void parsearMap(String json) {
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> map = null;
		try {
			map = objectMapper.readValue(json, new TypeReference<Map<String,Object>>(){} );
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(map);
		System.out.println(map.get("nombre"));
		
	}
	

}
