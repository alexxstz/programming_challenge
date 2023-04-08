package de.bcxp.challenge;
import de.bcxp.challenge.reader.CsvDataReader;
import de.bcxp.challenge.weather.*;
import de.bcxp.challenge.country.*;

import java.util.Arrays;
import java.util.List;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        // Your preparation code …
        WeatherStorage weatherStorage = new WeatherStorage("src/main/resources/de/bcxp/challenge/weather.csv");
        WeatherService weatherService = new WeatherService(weatherStorage);
        WeatherDay dayWithSmallestTempSpread = weatherService.getDayWithSmallestTempSpread();

        System.out.printf("Day with smallest temperature spread: %s%n", dayWithSmallestTempSpread.getOrdinalNumber());

        CountryStorage countryStorage = new CountryStorage("src/main/resources/de/bcxp/challenge/countries.csv");
        CountryService countryService = new CountryService(countryStorage);
        Country countryWithHighestPopulationDensity = countryService.getCountryWithHighestDensity(); // Your population density analysis function call …
        System.out.printf("Country with highest population density: %s%n", countryWithHighestPopulationDensity.getName());
    }
}
