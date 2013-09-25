package discount_strategy;

/**
 * An implementation of the IDiscount interface. Used to calculate the amount 
 * of a Buy One Get One Free discount from a quantity and unit price.
 * 
 * @author Tracy Kobel
 */
public class BOGODiscount implements IDiscount {
    private static final int FREE_ONE = 2;
    private String discountDescription = "Buy " + (FREE_ONE-1) + " get 1 free";           
    /**
     * 
     * @param qty quantity of units to be discounted
     * @param price price per unit
     * @return BOGO discount amount
     */
    @Override
    public double getDiscountAmount(int qty, double price) {
        return (qty/FREE_ONE) * price;
    }
    /**
     * A description of the discount
     * @return 
     */
    @Override
    public String getDiscountDescription() {
        return discountDescription;
    }    
}
