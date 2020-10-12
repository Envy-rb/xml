package com.envy.candies.entity;

public class Chocolate extends Candy{
    private boolean filling;
    private String chocolateKind;

    public boolean isFilling() {
        return filling;
    }

    public void setFilling(boolean filling) {
        this.filling = filling;
    }

    public String getChocolateKind() {
        return chocolateKind;
    }

    public void setChocolateKind(String chocolateKind) {
        this.chocolateKind = chocolateKind;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Chocolate chocolate = (Chocolate) o;

        if (filling != chocolate.filling) return false;
        return chocolateKind.equals(chocolate.chocolateKind);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (filling ? 1 : 0);
        result = 31 * result + chocolateKind.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(super.toString());
        sb.append(", filling=").append(filling);
        sb.append(", chocolateKind='").append(chocolateKind).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
