package de.bcxp.challenge.weather;

/**
 * Weather Day Class
 */
public class WeatherDay {
    private int ordinalNumber;

    private int minTemperature;

    private int maxTemperature;

    public WeatherDay(int ordinalNumber, int minTemperature, int maxTemperature){
        this.ordinalNumber = ordinalNumber;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
    }

    public int getOrdinalNumber() {
        return ordinalNumber;
    }

    public int getMaxTemperature() {
        return maxTemperature;
    }

    public int getMinTemperature() {
        return minTemperature;
    }

    public int getTemperatureDifference(){
        return Math.abs(maxTemperature - minTemperature);
    }
}
