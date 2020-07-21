package model;

import java.util.Objects;

public class Pricing {

    private int price;

    public Pricing(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pricing pricing = (Pricing) o;
        return price == pricing.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }
}
