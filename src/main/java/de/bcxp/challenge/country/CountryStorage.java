package de.bcxp.challenge.country;

import de.bcxp.challenge.reader.CsvDataReader;
import de.bcxp.challenge.country.Country;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.util.ArrayList;
import java.util.List;

public class CountryStorage {
    private static final Logger logger = LogManager.getLogger(CountryStorage.class);
    String filePath;

    public CountryStorage(String filePath){
        this.filePath = filePath;
    }

    public List<Country> getCountriesDaysFromFile(){
        CsvDataReader csvReader = new CsvDataReader(';');
        List<String[]> stringsFromFile = csvReader.readData(filePath);
        List<Country> countriesList = new ArrayList<>();

        for(int i = 0; i < stringsFromFile.size(); i++){
            countriesList.add(convertStringArrayToCountry(stringsFromFile.get(i)));
        }
        return countriesList;
    }

    private Country convertStringArrayToCountry(String[] string){
        String name = string[0];
        double population = convertStringToDouble(string[3]);
        double area = convertStringToDouble(string[4]);

        return new Country(name, population, area);
    }

    private double convertStringToDouble(String num){
        int countDots = 0;
        int countCommas = 0;
        double convertedNum = 0;

        // Count dots and commas in string
        for(int i = 0; i < num.length(); i++){
            if(num.charAt(i) == '.'){
                countDots++;
            }

            if(num.charAt(i) == ','){
                countCommas++;
            }
        }

        // Numbers without separators
        if(countDots == 0 && countCommas == 0){
            return Double.parseDouble(num);
        }

        if(countDots > 1 && countCommas > 1){
            logger.error("Invalid number with too many separators");
        }

        // Separator is a dot, commas separate hundreds
        if(countDots == 1 && countCommas > 1){
            num = num.replace(",", "");
            convertedNum = Double.parseDouble(num);
        }

        // Separator is a comma, dot seperates hundreds
        if(countDots > 1 && countCommas == 1){
            num = num.replace(".", "").replace(",","."); // Replace the comma separator with a dot
            convertedNum = Double.parseDouble(num);
        }

        return convertedNum;
    }

}
