package de.bcxp.challenge.weather;

import java.util.List;

public class WeatherService {
    WeatherStorage weatherStorage;

    public WeatherService(WeatherStorage weatherStorage) {
        this.weatherStorage = weatherStorage;
    }

    /**
     *
     * @param filePath of weather csv file
     * @return WeatherDay with smallest temperature spread. If two or more days have the same spread, it returns the last WeatherDay in the csv file.
     */
    public WeatherDay getDayWithSmallestTempSpread() {
        List<WeatherDay> weatherDayList = weatherStorage.getWeatherDaysFromFile();

        // Initial minSpread is the first day in weatherDayList
        int minSpread = weatherDayList.get(0).getTemperatureDifference();
        int minSpreadOrdinalNumber = 1;

        for (int i = 1; i < weatherDayList.size(); i++){
            WeatherDay currentDay = weatherDayList.get(i);
            int currSpread = currentDay.getTemperatureDifference();

            if (currSpread <= minSpread){
                minSpreadOrdinalNumber = currentDay.getOrdinalNumber();
                minSpread = currentDay.getTemperatureDifference();
            }

        }


        return weatherDayList.get(minSpreadOrdinalNumber-1);
    }
}


