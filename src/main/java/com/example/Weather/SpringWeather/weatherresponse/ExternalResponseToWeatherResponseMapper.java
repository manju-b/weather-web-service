package com.example.Weather.SpringWeather.weatherresponse;

import org.springframework.stereotype.Component;

import com.example.Weather.SpringWeather.external.ExternalResponseResource;
import com.example.Weather.SpringWeather.external.Wind;

@Component
public class ExternalResponseToWeatherResponseMapper {

	
	public WeatherResponseResource mappingExternalResponseToWeatherResponse(ExternalResponseResource externalResponse) {
		WeatherResponseResource weatherResponse = new WeatherResponseResource();
		if(externalResponse != null) {
			//check to avoid null pointer exception
			if(externalResponse.getWeather() != null && externalResponse.getWeather().get(0) != null) {
				weatherResponse.setDescription(externalResponse.getWeather().get(0).getDescription());
			}
			if(externalResponse.getWind() != null) {
				Wind w = externalResponse.getWind();
				weatherResponse.setSpeed(w.getSpeed());
			}
			if(externalResponse.getMain() != null) {
				weatherResponse.setTemp(externalResponse.getMain().getTemp());
			}
			weatherResponse.setName(externalResponse.getName());
		}
		
		return weatherResponse;
	}
	
}
