package de.bcxp.challenge.country;

import de.bcxp.challenge.reader.CsvDataReader;
import de.bcxp.challenge.country.Country;

import java.util.ArrayList;
import java.util.List;

public class CountryStorage {

    String filePath;

    public CountryStorage(String filePath){
        this.filePath = filePath;
    }

    public List<Country> getCountriesDaysFromFile(){
        CsvDataReader csvReader = new CsvDataReader();
        List<String[]> stringsFromFile = csvReader.readData(filePath);
        List<Country> countriesList = new ArrayList<>();

        for(int i = 0; i < stringsFromFile.size(); i++){
            countriesList.add(convertStringArrayToCountry(stringsFromFile.get(i)));
        }
        return countriesList;
    }

    private Country convertStringArrayToCountry(String[] string){
        String name = string[0];
        long population = Long.parseLong(string[3]);
        double area = Double.parseDouble(string[4]);

        return new Country(name, population, area);
    }
}
