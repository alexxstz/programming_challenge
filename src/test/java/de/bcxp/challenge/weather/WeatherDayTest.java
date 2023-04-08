package de.bcxp.challenge.weather;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example JUnit 5 test case.
 */
class WeatherDayTest {

    @Test
    public void testGetTemperatureDifference() {
        WeatherDay day1 = new WeatherDay(1, 10, 20);
        assertEquals(10, day1.getTemperatureDifference());

        WeatherDay day2 = new WeatherDay(2, 15, 20);
        assertEquals(5, day2.getTemperatureDifference());

        WeatherDay day3 = new WeatherDay(3, 20, 10);
        assertEquals(10, day3.getTemperatureDifference());
    }

}