package de.bcxp.challenge.weather;


import org.junit.jupiter.api.Test;

import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Example JUnit 5 test case.
 */
class WeatherStorageTest {


    @Test
    public void testGetWeatherDaysFromFile_() {
        WeatherStorage weatherStorage = new WeatherStorage("src/test/resources/weather_test.csv");
        List<WeatherDay> weatherDaysList = weatherStorage.getWeatherDaysFromFile();
        assertNotNull(weatherDaysList);
        assertEquals(3, weatherDaysList.size());
        assertEquals(1, weatherDaysList.get(0).getOrdinalNumber());
        assertEquals(90, weatherDaysList.get(1).getMaxTemperature());
        assertEquals(19, weatherDaysList.get(2).getTemperatureDifference());
    }

}