package com.example.Weather.SpringWeather.external;

import java.util.List;

import org.springframework.stereotype.Component;


public class ExternalResponseResource {

	private List<Weather> weather;
	private Wind wind;
	private Main main;
	private String name;
	
	public ExternalResponseResource() {
		super();
	}
	
	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}
	
	public List<Weather> getWeather() {
		return weather;
	}

	public ExternalResponseResource(List<Weather> weather, Wind wind, Main main, String name) {
		super();
		this.weather = weather;
		this.wind = wind;
		this.main = main;
		this.name = name;
	}

	

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	
	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ExternalResponseResource [weather=" + weather + ", wind=" + wind + ", main=" + main + ", name=" + name
				+ "]";
	}

	
}
