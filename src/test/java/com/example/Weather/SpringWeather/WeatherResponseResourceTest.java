package com.example.Weather.SpringWeather;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Weather.SpringWeather.weatherresponse.WeatherResponseResource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@RunWith(SpringRunner.class)
public class WeatherResponseResourceTest {

	WeatherResponseResource wrr;
	
	@Before
	public void setUp() {
		wrr = new WeatherResponseResource();
	}
	
	@Test
	public void testValidateMethodWith_ValidInput() {
		try {
			wrr.setDescription("clear sky");
			wrr.setName("sunnyvale");
			wrr.setSpeed(210.76);
			wrr.setTemp(110.21);
			wrr.validate();
		} catch(IllegalArgumentException e) {
			Assert.assertNull(e.getMessage());
		}
	}
	
	@Test
	public void testValidateMethodWith_ValidInput_WhichHasDesciptionFieldAsEmpty() {
		try {
			wrr.setDescription("");
			wrr.setName("sunnyvale");
			wrr.setSpeed(210.76);
			wrr.setTemp(110.21);
			wrr.validate();
		} catch(IllegalArgumentException e) {
			Assert.assertNull(e.getMessage());
		}
	}
	
	@Test
	public void testValidateMethodWith_ValidInput_WhichHasNameFieldAsEmpty() {
		try {
			wrr.setDescription("clear sky");
			wrr.setName("");
			wrr.setSpeed(210.76);
			wrr.setTemp(110.21);
			wrr.validate();
		} catch(IllegalArgumentException e) {
			Assert.assertNull(e.getMessage());
		}
	}
	
	@Test
	public void testValidateMethodWith_ValidInput_WhichHasSpeedFieldAsDefaultValue() {
		try {
			wrr.setDescription("clear sky");
			wrr.setName("sunnyvale");
			wrr.setSpeed(0);
			wrr.setTemp(110.21);
			wrr.validate();
		} catch(IllegalArgumentException e) {
			Assert.assertNull(e.getMessage());
		}
	}
	
	@Test
	public void testValidateMethodWith_ValidInput_WhichHasTempFieldAsDefaultValue() {
		try {
			wrr.setDescription("clear sky");
			wrr.setName("sunnyvale");
			wrr.setSpeed(210.76);
			wrr.setTemp(0);
			wrr.validate();
		} catch(IllegalArgumentException e) {
			Assert.assertNull(e.getMessage());
		}
	}
	
	@Test
	public void testValidateMethodWith_InvalidInput() {
		try {
			wrr.setDescription("");
			wrr.setName("");
			wrr.setSpeed(0);
			wrr.setTemp(0);
			wrr.validate();
		} catch(IllegalArgumentException e) {
			Assert.assertEquals("Please provide valid city name or zipcode", e.getMessage());
		}
	}
	
	
}
