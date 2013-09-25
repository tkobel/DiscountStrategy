package discount_strategy;

import java.text.NumberFormat;

/**
 *
 * @author Tracy Kobel
 */
public class QuantityDiscount implements IDiscount {
    
    private int qtyRequired;
    private double discountedPriceForLot;
    private String discountDescription;
    private NumberFormat money = NumberFormat.getCurrencyInstance();
    
    public QuantityDiscount(int qtyRequired, double discountedPriceForLot) {
        this.qtyRequired = qtyRequired;
        this.discountedPriceForLot = discountedPriceForLot;
        discountDescription = Integer.toString(qtyRequired) + " for "
                                         + money.format(discountedPriceForLot);
    }
    
    @Override
    public double getDiscountAmount(int qty, double price) {
        double regPriceForLot = qty * price;
        double differenceOfRegLotAndDiscountedLot = regPriceForLot - discountedPriceForLot;
        
        return (qty/qtyRequired) * differenceOfRegLotAndDiscountedLot;
    }
    @Override
    public String getDiscountDescription() {
        return discountDescription;
    }
}
