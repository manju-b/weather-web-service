package com.example.Weather.SpringWeather.external;

import org.springframework.stereotype.Component;


public class Wind {

	private double speed;
	private double deg;

	public Wind() {
		super();
	}

	public Wind(int speed, double deg) {
		super();
		this.speed = speed;
		this.deg = deg;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	
	public double getDeg() {
		return deg;
	}

	public void setDeg(double deg) {
		this.deg = deg;
	}

	@Override
	public String toString() {
		return "Wind [speed=" + speed + ", deg=" + deg + "]";
	}
	
	
}
