package com.envy.candies.entity;

public abstract class Candy {
    private String name;
    private double proteins;
    private double fats;
    private double carbos;
    private String production;
    private double water;
    private double sugar;
    private double fructose;
    private double vanilla;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public double getCarbos() {
        return carbos;
    }

    public void setCarbos(double carbos) {
        this.carbos = carbos;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public double getWater() {
        return water;
    }

    public void setWater(double water) {
        this.water = water;
    }

    public double getSugar() {
        return sugar;
    }

    public void setSugar(double sugar) {
        this.sugar = sugar;
    }

    public double getFructose() {
        return fructose;
    }

    public void setFructose(double fructose) {
        this.fructose = fructose;
    }

    public double getVanilla() {
        return vanilla;
    }

    public void setVanilla(double vanilla) {
        this.vanilla = vanilla;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Candy candy = (Candy) o;

        if (Double.compare(candy.proteins, proteins) != 0) return false;
        if (Double.compare(candy.fats, fats) != 0) return false;
        if (Double.compare(candy.carbos, carbos) != 0) return false;
        if (Double.compare(candy.water, water) != 0) return false;
        if (Double.compare(candy.sugar, sugar) != 0) return false;
        if (Double.compare(candy.fructose, fructose) != 0) return false;
        if (Double.compare(candy.vanilla, vanilla) != 0) return false;
        if (!name.equals(candy.name)) return false;
        return production.equals(candy.production);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(proteins);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(fats);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(carbos);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + production.hashCode();
        temp = Double.doubleToLongBits(water);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(sugar);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(fructose);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(vanilla);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Candy{");
        sb.append("name='").append(name).append('\'');
        sb.append(", proteins=").append(proteins);
        sb.append(", fats=").append(fats);
        sb.append(", carbos=").append(carbos);
        sb.append(", production='").append(production).append('\'');
        sb.append(", water=").append(water);
        sb.append(", sugar=").append(sugar);
        sb.append(", fructose=").append(fructose);
        sb.append(", vanilla=").append(vanilla);
        return sb.toString();
    }
}
