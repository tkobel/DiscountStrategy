package discount.strategy;
import exceptions.*;

/**
 * An implementation of the DiscountStrategy interface. Used for a Buy One Get One Free
 * Discount.
 * 
 * @author Tracy Kobel
 */
public class BOGODiscount implements DiscountStrategy {
    private static final int FREE_ONE = 2;
    private String discountDescription = "Buy " + (FREE_ONE-1) + " get 1 free";
    private static final String QTY_ERR = "Invalid Quantity. Must be an "
            + "integer greater than 0";
    private static final String PRICE_ERR = "Ivalid Price. Must be greater than 0";
    /**
     * Gets the amount to discount off of the extended price for the given
     * quantity and unit price
     * @param qty quantity of units to be discounted
     * @param price list price per unit
     * @return the amount to discount for a give quantity
     * @throws IllegalArgumentException if quantity or price is less than 0
     */
    @Override
    public double getDiscountAmount(int qty, double price) throws IllegalArgumentException {
        if ( qty < 0) {
            throw new IllegalArgumentException();
        }
        if (price <0) {
            throw new IllegalArgumentException();
        }
        return (qty/FREE_ONE) * price;
    }
    /**
     * A description of the discount
     * @return a description of the discount
     */
    @Override
    public String getDiscountDescription() {
        return discountDescription;
    }    
}
