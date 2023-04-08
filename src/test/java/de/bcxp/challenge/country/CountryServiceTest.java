package de.bcxp.challenge.country;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountryServiceTest {

    public static CountryStorage countryStorage = null;
    public static CountryService countryService = null;

    @BeforeAll
    public static void setUp() {
        countryStorage = new CountryStorage("src/test/resources/country_test.csv");
        countryService = new CountryService(countryStorage);
    }

    @Test
    public void testGetCountryWithHighestDensity() {
        assertEquals("Netherlands", countryService.getCountryWithHighestDensity().getName());

    }

}
