package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WeatherForecastTestSuite {

    @Mock
    private Temperatures temperaturesMock;
    private WeatherForecast weatherForecast;
    private Map<String, Double> temperaturesMap;

    @BeforeEach
    void setUp(){
        temperaturesMap = new HashMap<>();

        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);

        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        weatherForecast = new WeatherForecast(temperaturesMock);
    }

    @Test
    void testCalculateForecastWithMock() {

        int quantityOfSensors = weatherForecast.calculateForecast().size();

        Assertions.assertEquals(5, quantityOfSensors);
    }
    @Test
    void testGetAverageTemperature() {
        double averageTemperature = weatherForecast.getAverageTemperature();

        Assertions.assertEquals(25.56, averageTemperature, 0.01);
    }

    @Test
    void testGetMedianTemperature() {
        double median = weatherForecast.getMedianTemperature();

        Assertions.assertEquals(25.5, median, 0.01);
    }


}
