package com.example.Weather.SpringWeather;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Weather.SpringWeather.external.ExternalResponseResource;
import com.example.Weather.SpringWeather.external.Main;
import com.example.Weather.SpringWeather.external.Weather;
import com.example.Weather.SpringWeather.external.Wind;
import com.example.Weather.SpringWeather.weatherresponse.ExternalResponseToWeatherResponseMapper;
import com.example.Weather.SpringWeather.weatherresponse.WeatherResponseResource;

@RunWith(SpringRunner.class)
public class ExternalResponseToWeatherResponseMapperTest {

	ExternalResponseToWeatherResponseMapper mapper;
	ExternalResponseResource err;
	WeatherResponseResource wrr;
	
	@Test
	public void mappingExternalResponseToWeatherResponseTest_MakingWeatherListAsNull() {
		err = new ExternalResponseResource();
		Main main = new Main();
		main.setTemp(210.98);
		List<Weather> weatherList = null;
		Wind wind = new Wind();
		wind.setSpeed(170.6);
		err.setMain(main);
		err.setWeather(weatherList);
		err.setName("sunnyvale");
		err.setWind(wind);
		wrr = new WeatherResponseResource();
		wrr.setName(err.getName());
		wrr.setSpeed(err.getWind().getSpeed());
		wrr.setTemp(err.getMain().getTemp());
		mapper = new ExternalResponseToWeatherResponseMapper();
		WeatherResponseResource response = mapper.mappingExternalResponseToWeatherResponse(err);
		Assert.assertEquals(wrr.toString(), response.toString());
	}
	
	@Test
	public void testMappingExternalResponseToWeatherResponse_MakingWeatherListAsEmpty() {
		err = new ExternalResponseResource();
		Main main = new Main();
		main.setTemp(210.98);
		List<Weather> weatherList = new ArrayList<>();
		Wind wind = new Wind();
		wind.setSpeed(170.6);
		err.setMain(main);
		err.setWeather(weatherList);
		err.setName("sunnyvale");
		err.setWind(wind);
		wrr = new WeatherResponseResource();
		wrr.setName(err.getName());
		wrr.setSpeed(err.getWind().getSpeed());
		wrr.setTemp(err.getMain().getTemp());
		mapper = new ExternalResponseToWeatherResponseMapper();
		WeatherResponseResource response = mapper.mappingExternalResponseToWeatherResponse(err);
		Assert.assertEquals(wrr.toString(), response.toString());
	}
	
	@Test
	public void testMappingExternalResponseToWeatherResponse_MakingWeatherListAsNull() {
		err = new ExternalResponseResource();
		Main main = new Main();
		main.setTemp(210.98);
		List<Weather> weatherList = null;
		Wind wind = new Wind();
		wind.setSpeed(170.6);
		err.setMain(main);
		err.setWeather(weatherList);
		err.setName("sunnyvale");
		err.setWind(wind);
		wrr = new WeatherResponseResource();
		wrr.setName(err.getName());
		wrr.setSpeed(err.getWind().getSpeed());
		wrr.setTemp(err.getMain().getTemp());
		mapper = new ExternalResponseToWeatherResponseMapper();
		WeatherResponseResource response = mapper.mappingExternalResponseToWeatherResponse(err);
		Assert.assertEquals(wrr.toString(), response.toString());
	}
	
	@Test
	public void testMappingExternalResponseToWeatherResponse_MakingWindAsNull() {
		err = new ExternalResponseResource();
		Main main = new Main();
		main.setTemp(210.98);
		Weather weather = new Weather();
		weather.setDescription("Clear sky");
		List<Weather> weatherList = new ArrayList<>();
		weatherList.add(weather);
		Wind wind = null;
		err.setWind(wind);
		err.setMain(main);
		err.setWeather(weatherList);
		err.setName("sunnyvale");
		err.setWind(wind);
		wrr = new WeatherResponseResource();
		wrr.setName(err.getName());
		wrr.setTemp(err.getMain().getTemp());
		wrr.setDescription(err.getWeather().get(0).getDescription());
		mapper = new ExternalResponseToWeatherResponseMapper();
		WeatherResponseResource response = mapper.mappingExternalResponseToWeatherResponse(err);
		Assert.assertEquals(wrr.toString(), response.toString());
	}
	
	@Test
	public void testMappingExternalResponseToWeatherResponse_MakingMainAsNull() {
		err = new ExternalResponseResource();
		Main main = null;
		Weather weather = new Weather();
		weather.setDescription("Clear sky");
		List<Weather> weatherList = new ArrayList<>();
		weatherList.add(weather);
		Wind wind = new Wind();
		wind.setSpeed(170.6);
		err.setMain(main);
		err.setWeather(weatherList);
		err.setName("sunnyvale");
		err.setWind(wind);
		wrr = new WeatherResponseResource();
		wrr.setName(err.getName());
		wrr.setSpeed(err.getWind().getSpeed());
		wrr.setDescription(err.getWeather().get(0).getDescription());
		mapper = new ExternalResponseToWeatherResponseMapper();
		WeatherResponseResource response = mapper.mappingExternalResponseToWeatherResponse(err);
		Assert.assertEquals(wrr.toString(), response.toString());
	}
	
	@Test
	public void testMappingExternalResponseToWeatherResponse_MakingNameAsNull() {
		err = new ExternalResponseResource();
		Main main = new Main();
		main.setTemp(210.98);
		Weather weather = new Weather();
		weather.setDescription("Clear sky");
		List<Weather> weatherList = new ArrayList<>();
		weatherList.add(weather);
		Wind wind = new Wind();
		wind.setSpeed(170.6);
		err.setMain(main);
		err.setWeather(weatherList);
		err.setWind(wind);
		wrr = new WeatherResponseResource();
		wrr.setSpeed(err.getWind().getSpeed());
		wrr.setTemp(err.getMain().getTemp());
		wrr.setDescription(err.getWeather().get(0).getDescription());
		mapper = new ExternalResponseToWeatherResponseMapper();
		WeatherResponseResource response = mapper.mappingExternalResponseToWeatherResponse(err);
		Assert.assertEquals(wrr.toString(), response.toString());
	}
	
	@Test
	public void testMappingExternalResponseToWeatherResponse_ValidInput() {
		err = new ExternalResponseResource();
		Main main = new Main();
		main.setTemp(210.98);
		Weather weather = new Weather();
		weather.setDescription("Clear sky");
		List<Weather> weatherList = new ArrayList<>();
		weatherList.add(weather);
		Wind wind = new Wind();
		wind.setSpeed(170.6);
		err.setMain(main);
		err.setWeather(weatherList);
		err.setWind(wind);
		err.setName("sunnyvale");
		wrr = new WeatherResponseResource();
		wrr.setSpeed(err.getWind().getSpeed());
		wrr.setTemp(err.getMain().getTemp());
		wrr.setName(err.getName());
		wrr.setDescription(err.getWeather().get(0).getDescription());
		mapper = new ExternalResponseToWeatherResponseMapper();
		WeatherResponseResource response = mapper.mappingExternalResponseToWeatherResponse(err);
		Assert.assertEquals(wrr.toString(), response.toString());
	}
	
}
