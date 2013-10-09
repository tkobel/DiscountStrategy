package discount.strategy;

import java.text.NumberFormat;

/**
 * An implementation of the DiscountStrategy interface. Used for getting the amount of 
 * the percentage taken off of an original price
 * @author Tracy Kobel
 */
public class PercentDiscount implements DiscountStrategy {
   
    private double discountPercentage;
    private String discountDescription;
    private NumberFormat percent = NumberFormat.getPercentInstance();
    private static final String AMOUNT_ERR = "Amount must be greater than 0";
    public static final String PERCENTAGE_ERR = "The value must be in the range"
            + " of 0-1.";
    /**
     * Custom Constructor. Requires a percentage to discount off of a price
     * @param discountPercentage the percentage amount to discount, must be 
     * in the range of 0-1.
     * @throws IllegalArgumentException if discountPercentage is less than 0 or
     * greater than 1
     */
    public PercentDiscount(double discountPercentage) {
        if(discountPercentage < 0 || discountPercentage > 1) {
            throw new IllegalArgumentException(PERCENTAGE_ERR);
        }
        this.discountPercentage = discountPercentage;
        discountDescription = percent.format(discountPercentage) + " off";
    }
    /**
     * Gets the amount to discount off of the extended price for the given
     * quantity and unit price
     * @param qty total quantity of a single item in a transaction
     * @param price list price for 1 unit of the product to be discounted
     * @return the amount to be subtracted from the extended price
     * @throws IllegalArgumentException if qty or price is less than 0
     */
    @Override
    public double getDiscountAmount(int qty, double price) {
        if(qty < 0 || price < 0) {
            throw new IllegalArgumentException(AMOUNT_ERR);
        }
        return price * discountPercentage * qty;
    }
    /**
     * Gets a description of the discount
     * @return a description of the discount
     */
    @Override
    public String getDiscountDescription() {
        return discountDescription;
    }  
}
