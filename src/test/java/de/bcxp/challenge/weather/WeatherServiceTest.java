package de.bcxp.challenge.weather;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class WeatherServiceTest {

    static WeatherStorage weatherStorage = null;
    static WeatherService weatherService = null;
    @BeforeAll
    public static void setUp() {
        weatherStorage = new WeatherStorage("src/test/resources/weather_test.csv");
        weatherService = new WeatherService(weatherStorage);
    }


    @Test
    public void testGetDayWithSmallestTempSpread(){
        assertEquals(new WeatherDay(1,57,73), weatherService.getDayWithSmallestTempSpread());
    }

}
