package de.bcxp.challenge.country;

public class Country {
    private String name;
    private double population;
    private double area;

    public Country(String name, double population, double area){
        this.name = name;
        this.population = population;
        this.area = area;
    }

    // Getter
    public String getName(){
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
}
