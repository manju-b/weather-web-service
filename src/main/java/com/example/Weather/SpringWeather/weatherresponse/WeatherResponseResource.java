package com.example.Weather.SpringWeather.weatherresponse;

import org.springframework.util.ObjectUtils;

public class WeatherResponseResource {

	String description;
	double speed;
	double temp;
	String name;
	
	public WeatherResponseResource() {
		super();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void validate() {
		if(description != null || speed != 0 || temp != 0 || name != null) {
			
		} else  {
	 		throw new IllegalArgumentException("Please provide valid city name or zipcode");
		}
	}
	
}
