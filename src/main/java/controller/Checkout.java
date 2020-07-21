package controller;

import model.Pricing;
import model.SKU;

import java.util.HashMap;
import java.util.Map;

public class Checkout {

    private Map<SKU, Pricing> pricingScheme;
    private int currentBalance;

    public Checkout() {
        pricingScheme = new HashMap<>();

        pricingScheme.put(new SKU("A"), new Pricing( 50));
        pricingScheme.put(new SKU("B"), new Pricing( 30));
        pricingScheme.put(new SKU("C"), new Pricing( 20));
        pricingScheme.put(new SKU("D"), new Pricing( 15));
    }

    public int calculateTotal(String validatedInput, int validatedQuantity) {

        if (pricingScheme.containsKey(new SKU(validatedInput))) {
            Pricing newPrice = pricingScheme.get(new SKU(validatedInput));

            int newItemOffersApplied = calculateSpecialOffers(validatedInput,
                    validatedQuantity,
                    newPrice.getPrice() * validatedQuantity);

            currentBalance += newItemOffersApplied;

        } else {
            System.out.println("Item found in the system");
        }

        return currentBalance;
    }

    //  This needs extrapolating for future offers, also it only works if the correct offer quantity is entered
    private int calculateSpecialOffers(String validatedInput, int validatedQuantity, int newItemGrossPrice) {

        if (validatedInput.equals("A")) {
            if (newItemGrossPrice % 3 == 0) {
                int timesOffer = validatedQuantity / 3;
                return timesOffer * 130;
            } else return newItemGrossPrice;
        } else if (validatedInput.equals("B")) {
            if (newItemGrossPrice % 2 == 0) {
                int timesOffer = validatedQuantity / 2;
                return timesOffer * 45;
            } else return newItemGrossPrice;
        }
        return newItemGrossPrice;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }
}
