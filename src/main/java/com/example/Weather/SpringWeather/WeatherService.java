package com.example.Weather.SpringWeather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Weather.SpringWeather.external.ExternalResponseResource;
import com.example.Weather.SpringWeather.external.ExternalResponseResourceDeserializer;
import com.example.Weather.SpringWeather.httpclient.RestClient;
import com.example.Weather.SpringWeather.weatherresponse.ExternalResponseToWeatherResponseMapper;
import com.example.Weather.SpringWeather.weatherresponse.WeatherResponseResource;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class WeatherService {
	@Autowired
	ExternalResponseToWeatherResponseMapper mapper;
	@Autowired
	ExternalResponseResourceDeserializer deserialize;
	@Autowired
	RestClient restClient;
	
	public WeatherResponseResource cityWeatherReport(String cityName) {
		String url;
		if(cityName.matches("[a-zA-Z]+")) {
			url = "http://api.openweathermap.org/data/2.5/weather?q=" + cityName + ",us&APPID=15dd8deaa5771ca36e3ca578f3c9773a";
		} else {
			url = "http://api.openweathermap.org/data/2.5/weather?zip=" + cityName + ",us&APPID=15dd8deaa5771ca36e3ca578f3c9773a";
		}
		StringBuilder result = restClient.doGet(url);
		ExternalResponseResource externalResponse = deserialize.jsonToObject(result);
		WeatherResponseResource weatherResponse = mapper.mappingExternalResponseToWeatherResponse(externalResponse);
		return weatherResponse;
	}
	
}
