package com.example.Weather.SpringWeather.external;

import org.springframework.stereotype.Component;

public class Main {
	
	private double temp;
	private int humidity;
	private double pressure;
	private double temp_min;
	private double temp_max;
	
	public Main() {
		super();
	}

	public Main(double temp, int humidity, double pressure, double temp_min, double temp_max) {
		super();
		this.temp = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		this.temp_min = temp_min;
		this.temp_max = temp_max;
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	
	public double getPressure() {
		return pressure;
	}

	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

	public double getTemp_min() {
		return temp_min;
	}

	public void setTemp_min(double temp_min) {
		this.temp_min = temp_min;
	}

	public double getTemp_max() {
		return temp_max;
	}

	public void setTemp_max(double temp_max) {
		this.temp_max = temp_max;
	}

	@Override
	public String toString() {
		return "Main [temp=" + temp + ", humidity=" + humidity + ", pressure=" + pressure + ", temp_min=" + temp_min
				+ ", temp_max=" + temp_max + "]";
	}
	
	
	
}
