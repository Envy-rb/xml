package com.envy.candies.entity;

public class Caramel extends Candy{
    private String flavour;

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Caramel caramel = (Caramel) o;

        return flavour.equals(caramel.flavour);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + flavour.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(super.toString());
        sb.append(", flavour='").append(flavour).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
