package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }
    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()){
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double getAverageTemperature() {

        double sum= 0.0;
        int size = temperatures.getTemperatures().size();

        for (double temp : temperatures.getTemperatures().values()){
            sum += temp;
        }
        return sum/size;
    }

    public double getMedianTemperature() {
        List<Double> tempList = new ArrayList<>(temperatures.getTemperatures().values());
        Collections.sort(tempList);

        int listSize = tempList.size();

        if(listSize == 0){
            return 0;
        } else if(listSize % 2 == 1){
            return tempList.get(listSize / 2);
        } else {
            double num1 = tempList.get((listSize / 2) - 1);
            double num2 = tempList.get(listSize / 2);
            return (num1 + num2)/2;
        }
    }

}
