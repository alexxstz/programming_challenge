package de.bcxp.challenge.country;

import java.util.Objects;

/**
 * Class for a Country. Contains name, population and area. Can calculate the densitiy.
 */
public class Country {
    private String name;
    private double population;
    private double area;

    public Country(String name, double population, double area) {
        this.name = name;
        this.population = population;
        this.area = area;
    }

    // Getter
    public String getName() {
        return name;
    }

    public double getPopulation() {
        return population;
    }

    public double getArea() {
        return area;
    }

    public double getDensity() {
        return population / area;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Country)) {
            return false;
        }
        Country country = (Country) o;
        return Double.compare(country.population, population) == 0
                && Double.compare(country.area, area) == 0
                && Objects.equals(name, country.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, population, area);
    }


}
