package com.example.Weather.SpringWeather;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.Weather.SpringWeather.weatherresponse.WeatherResponseResource;


public class WeatherControllerTest {
	
	@Mock
	WeatherService service;
	
	@InjectMocks
	WeatherController weatherController;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetWeatherReportWith_ValidCityName() {
		WeatherResponseResource response = new WeatherResponseResource();
		response.setDescription("clear sky");
		response.setName("sunnyvale");
		response.setSpeed(4.6);
		response.setTemp(290.34);
		when(service.cityWeatherReport("sunnyvale")).thenReturn(response);
		Assert.assertEquals(response, weatherController.getWeatherReport("sunnyvale"));
	}
	
	@Test
	public void testGetWeatherReportWith_ValidZipcode() {
		WeatherResponseResource response = new WeatherResponseResource();
		response.setDescription("clear sky");
		response.setName("mountain view");
		response.setSpeed(4.6);
		response.setTemp(234.78);
		when(service.cityWeatherReport("94043")).thenReturn(response);
		Assert.assertEquals(response, weatherController.getWeatherReport("94043"));
	}
	
	@Test
	public void testGetWeatherReportWith_InValidCityName() {
		WeatherResponseResource response = new WeatherResponseResource();
		when(service.cityWeatherReport("hsnjamjd")).thenReturn(response);
		try{
			weatherController.getWeatherReport("hsnjamjd");
		} catch(IllegalArgumentException e) {
			Assert.assertEquals("Please provide valid city name or zipcode", e.getMessage());
		}
	}
	
	@Test
	public void testGetWeatherReportWith_InValidZipcode() {
		WeatherResponseResource response = new WeatherResponseResource();
		when(service.cityWeatherReport("090909")).thenReturn(response);
		try{
			weatherController.getWeatherReport("090909");
		} catch(IllegalArgumentException e) {
			Assert.assertEquals("Please provide valid city name or zipcode", e.getMessage());
		}
	}
	
	@Test
	public void testGetWeatherReportWith_InValidInput() {
		WeatherResponseResource response = new WeatherResponseResource();
		when(service.cityWeatherReport("hs7484mjd")).thenReturn(response);
		try{
			weatherController.getWeatherReport("hs7484mjd");
		} catch(IllegalArgumentException e) {
			Assert.assertEquals("Please provide valid city name or zipcode", e.getMessage());
		}
	}
	
	@Test
	public void testGetWeatherReportWith_ValidInput() {
		WeatherResponseResource response = new WeatherResponseResource();
		response.setName("fremont");
		response.setSpeed(6.6);
		response.setTemp(278.21);
		when(service.cityWeatherReport("fremont")).thenReturn(response);
		Assert.assertEquals(response, weatherController.getWeatherReport("fremont"));
	}
}
