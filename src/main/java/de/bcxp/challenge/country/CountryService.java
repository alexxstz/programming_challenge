package de.bcxp.challenge.country;

import de.bcxp.challenge.country.CountryService;
import de.bcxp.challenge.weather.WeatherDay;

import java.util.List;

/**
 * Service class for Country. Takes a countryStorage object and returns the country with the highest densitiy from the countryStorage.
 */

public class CountryService {

    CountryStorage countryStorage;

    public CountryService(CountryStorage countryStorage) {
        this.countryStorage = countryStorage;
    }

    /**
     * method to get the country with the highest density. If two countries have the same density, it returns the country with the greater index in the csv file.
     *
     * @return country with highest density
     */
    public Country getCountryWithHighestDensity() {
        List<Country> countriesList = countryStorage.getCountriesDaysFromFile();

        Country maxDensityCountry = countriesList.get(0);

        for (int i = 1; i < countriesList.size(); i++) {
            Country currCountry = countriesList.get(i);
            double currDensity = currCountry.getDensity();

            if (currDensity >= maxDensityCountry.getDensity()) {
                maxDensityCountry = currCountry;
            }

        }
        return maxDensityCountry;
    }
}
