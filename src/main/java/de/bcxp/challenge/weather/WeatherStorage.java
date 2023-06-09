package de.bcxp.challenge.weather;

import de.bcxp.challenge.reader.CsvDataReader;

import java.util.ArrayList;
import java.util.List;

/**
 * Storage class for Weather Objects. Uses CsvDataReader to read from a csv file and map them to Weather Objects
 */
public class WeatherStorage {

    String filePath;

    public WeatherStorage(String filePath) {
        this.filePath = filePath;
    }

    public List<WeatherDay> getWeatherDaysFromFile() {
        CsvDataReader csvReader = new CsvDataReader(',', 1);
        List<String[]> stringsFromFile = csvReader.readData(filePath);
        List<WeatherDay> weatherDaysList = new ArrayList<>();

        for (int i = 0; i < stringsFromFile.size(); i++) {
            weatherDaysList.add(convertStringArrayToWeatherDay(stringsFromFile.get(i)));
        }
        return weatherDaysList;
    }

    private WeatherDay convertStringArrayToWeatherDay(String[] string) {
        int ordinalNumber = Integer.parseInt(string[0]);
        int minTemperature = Integer.parseInt(string[2]);
        int maxTemperature = Integer.parseInt(string[1]);

        return new WeatherDay(ordinalNumber, minTemperature, maxTemperature);
    }
}
