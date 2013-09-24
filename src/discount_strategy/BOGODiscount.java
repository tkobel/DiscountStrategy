package discount_strategy;

/**
 *
 * @author Tracy Kobel
 */
public class BOGODiscount implements Discount {
    private static final int FREE_ONE = 2;
    private String discountDescription = "Buy " + (FREE_ONE-1) + " get 1 free";           
    
    @Override
    public double getDiscountAmount(int qty, double price) {
        return (qty/FREE_ONE) * price;
    }
    @Override
    public String getDiscountDescription() {
        return discountDescription;
    }    
}
