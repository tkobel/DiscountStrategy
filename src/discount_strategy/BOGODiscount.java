package discount_strategy;

/**
 *
 * @author Tracy Kobel
 */
public class BOGODiscount implements Discount {
    private static final int FREE_ONE = 2;
    
    public BOGODiscount() {};
    
    @Override
    public double getDiscountAmount(LineItem ln) {
        return (ln.getQty()/FREE_ONE) * ln.getProduct().getUnitPrice();
    }
}
