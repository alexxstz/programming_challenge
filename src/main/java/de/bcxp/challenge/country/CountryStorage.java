package de.bcxp.challenge.country;

import de.bcxp.challenge.reader.CsvDataReader;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;
import java.util.List;

public class CountryStorage {
    private static final Logger logger = LogManager.getLogger(CountryStorage.class);
    String filePath;

    public CountryStorage(String filePath) {
        this.filePath = filePath;
    }

    public List<Country> getCountriesDaysFromFile() {
        CsvDataReader csvReader = new CsvDataReader(';', 0);
        List<String[]> stringsFromFile = csvReader.readData(filePath);
        List<Country> countriesList = new ArrayList<>();

        for (int i = 0; i < stringsFromFile.size(); i++) {
            countriesList.add(convertStringArrayToCountry(stringsFromFile.get(i)));
        }
        return countriesList;
    }

    private Country convertStringArrayToCountry(String[] string) {
        String name = string[0];
        double population = convertStringToDouble(string[3]);
        double area = convertStringToDouble(string[4]);

        return new Country(name, population, area);
    }

    double convertStringToDouble(String num) {


        num = num.replace(',', '.');

        // Replace dots in the thousands separator with nothing
        num = num.replaceAll("\\.(?=.*\\.)", "");

        // Check if there's more than one dot or comma
        if (num.indexOf('.') != num.lastIndexOf('.') || num.indexOf(',') != num.lastIndexOf(',')) {
            logger.error("Error when converting string to number: " + num);
            throw new NumberFormatException("Invalid number format: " + num);
        }

        return Double.parseDouble(num);
    }

}
