package com.kodilla.testing.weather.stub;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WeatherForecastTestSuite {
    @Test
    void testCalculateForecastWithStub() {
        //Giiven
        Temperatures temperatures = new TemperaturesStub();
        WeatherForecast weatherForecast = new WeatherForecast(temperatures);
        //When
        int quantityOfSensors = weatherForecast.calcateForecast().size();
        //then
        Assertions.assertEquals(5,quantityOfSensors);
    }
}
