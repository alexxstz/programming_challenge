package de.bcxp.challenge.weather;

/**
 * Weather Day Class. Contains ordinalNumber(day of the month), min Temperature and max. Temperature
 */
public class WeatherDay {
    private int ordinalNumber;

    private int minTemperature;

    private int maxTemperature;

    public WeatherDay(int ordinalNumber, int minTemperature, int maxTemperature) {
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

    public int getTemperatureDifference() {
        return Math.abs(maxTemperature - minTemperature);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherDay that = (WeatherDay) o;
        return ordinalNumber == that.ordinalNumber &&
                minTemperature == that.minTemperature &&
                maxTemperature == that.maxTemperature;
    }

    @Override
    public int hashCode() {
        int result = ordinalNumber;
        result = 31 * result + minTemperature;
        result = 31 * result + maxTemperature;
        return result;
    }

}
