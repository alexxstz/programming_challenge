package de.bcxp.challenge.country;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CountryStorageTest {

    public static CountryStorage countryStorage = null;

    @BeforeAll
    public static void setUp(){
        countryStorage = new CountryStorage("src/test/resources/country_test.csv");
    }
    @Test
    public void testConvertStringToDouble(){
        assertEquals(1234, countryStorage.convertStringToDouble("1234"));
        assertEquals(123.4, countryStorage.convertStringToDouble("123,40"));
        assertEquals(1234000.00, countryStorage.convertStringToDouble(("1.234.000,00")));
    }

    @Test
    public void testGetCountriesFromFile(){
        List<Country> list = countryStorage.getCountriesDaysFromFile();

        Country bulgaria = new Country("Bulgaria", 6916548,110994);
        Country cyprus = new Country("Cyprus", 896000,9251);
        Country netherlands = new Country("Netherlands", 17614840,41543);

        assertTrue(bulgaria.equals(list.get(0)));
        assertTrue(cyprus.equals(list.get(1)));
        assertTrue(netherlands.equals(list.get(2)));

    }
}
