package com.example.Weather.SpringWeather;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
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
		return "Please provide cityname or zipcode to know city weather details";
	}
	
	
	@RequestMapping(value = "/Weather/{cityName}", method = RequestMethod.GET) 
	public WeatherResponseResource getWeatherReport(@PathVariable("cityName") String cityName) {
	 	if(cityName.matches("[a-zA-Z]+") || cityName.matches("^[0-9]*$")){
	 		WeatherResponseResource response = weatherService.cityWeatherReport(cityName);
	 		response.validate();
	 		return response;
	 	} else {
	 		throw new IllegalArgumentException("Please provide valid city name or zipcode");
	 	}
	}
}
