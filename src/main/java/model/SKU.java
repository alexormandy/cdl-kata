package model;

import java.util.Objects;

public class SKU {

    private String itemIdentifier;

    public SKU(String itemIdentifier) {
        this.itemIdentifier = itemIdentifier;
    }

    public String getItemIdentifier() {
        return itemIdentifier;
    }

    public void setItemIdentifier(String itemIdentifier) {
        this.itemIdentifier = itemIdentifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SKU sku = (SKU) o;
        return itemIdentifier.equals(sku.itemIdentifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemIdentifier);
    }
}
