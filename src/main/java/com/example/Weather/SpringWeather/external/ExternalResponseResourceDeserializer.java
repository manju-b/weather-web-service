package com.example.Weather.SpringWeather.external;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;
import org.codehaus.jackson.map.DeserializationConfig.Feature;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Component
public class ExternalResponseResourceDeserializer {

	public ExternalResponseResource jsonToObject(StringBuilder sb) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ExternalResponseResource externalResponse = null;
		try {
			externalResponse = mapper.readValue(sb.toString(), ExternalResponseResource.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return externalResponse;
	}
}
