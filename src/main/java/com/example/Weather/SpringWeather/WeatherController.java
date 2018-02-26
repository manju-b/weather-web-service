package com.example.Weather.SpringWeather;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Weather.SpringWeather.weatherresponse.WeatherResponseResource;

@RestController
public class WeatherController {

	@Autowired
	WeatherService weatherService;
	
	@ExceptionHandler
	void handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) throws IOException {
	    response.sendError(HttpStatus.BAD_REQUEST.value());
	}
	
	@RequestMapping(value = "/Weather", method = RequestMethod.GET)
	public String index() {
		throw new IllegalArgumentException("Please provide cityname");
	}
	
	
	@RequestMapping(value = "/Weather/{cityName}", method = RequestMethod.GET) 
	public WeatherResponseResource getWeatherReport(@PathVariable("cityName") String cityName) {
		
	 	if(cityName.matches("[a-zA-Z]+")){
	 		WeatherResponseResource response = weatherService.cityWeatherReport(cityName);
	 		if(response.isEmpty()) {
		 		throw new IllegalArgumentException("Please provide valid city name");
	 		} else {
	 			return response;
	 		}
	 	} else {
	 		throw new IllegalArgumentException("Please provide valid city name");
	 	}
	}
}
