package discount_strategy;

/**
 *
 * @author Tracy Kobel
 */
public class QtyDiscount implements Discount {
    
    private int qtyRequired;
    private double discountedPriceForLot;
//    private String discountMessage;
    
    public QtyDiscount(int qtyRequired, double discountedPriceForLot) {
        this.qtyRequired = qtyRequired;
        this.discountedPriceForLot = discountedPriceForLot;
//        discountMessage = Integer.toString(qtyRequired) + " for " + Double.toString(discountAmount);
    }
    
    @Override
    public double getDiscountAmount(LineItem ln) {
        Product item = ln.getProduct();
        double regPriceForLot = ln.getQty() * item.getUnitPrice();
        double differenceOfRegLotAndDiscountedLot = regPriceForLot - discountedPriceForLot;
        
        return (ln.getQty()/qtyRequired) * differenceOfRegLotAndDiscountedLot;
    }
}
