package com.example.Weather.SpringWeather.external;

import org.springframework.stereotype.Component;

public class Weather {

	private String description;
	private int id;
	private String main;
	private String icon;

	public Weather() {
		
	}
	
	public Weather(String description, int id, String main, String icon) {
		super();
		this.description = description;
		this.id = id;
		this.main = main;
		this.icon = icon;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Override
	public String toString() {
		return "Weather [description=" + description + ", id=" + id + ", main=" + main + ", icon=" + icon + "]";
	}
	
	
}
