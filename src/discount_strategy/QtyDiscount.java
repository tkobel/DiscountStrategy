package discount_strategy;

/**
 *
 * @author Tracy Kobel
 */
public class QtyDiscount implements Discount {
    
    private int qtyRequired;
    private double discountedAmount;
//    private String discountMessage;
    
    public QtyDiscount(int qtyRequired, double discountAmount) {
        this.qtyRequired = qtyRequired;
        this.discountedAmount = discountAmount;
//        discountMessage = Integer.toString(qtyRequired) + " for " + Double.toString(discountAmount);
    }
}
