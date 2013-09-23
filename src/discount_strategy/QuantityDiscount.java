package discount_strategy;

import java.text.NumberFormat;

/**
 *
 * @author Tracy Kobel
 */
public class QuantityDiscount implements Discount {
    
    private int qtyRequired;
    private double discountedPriceForLot;
    private String discountDescription;
    NumberFormat money = NumberFormat.getCurrencyInstance();
    
    public QuantityDiscount(int qtyRequired, double discountedPriceForLot) {
        this.qtyRequired = qtyRequired;
        this.discountedPriceForLot = discountedPriceForLot;
        discountDescription = Integer.toString(qtyRequired) + " for "
                                         + money.format(discountedPriceForLot);
    }
    
    @Override
    public double getDiscountAmount(LineItem ln) {
        Product item = ln.getProduct();
        double regPriceForLot = ln.getQty() * item.getUnitPrice();
        double differenceOfRegLotAndDiscountedLot = regPriceForLot - discountedPriceForLot;
        
        return (ln.getQty()/qtyRequired) * differenceOfRegLotAndDiscountedLot;
    }
    @Override
    public String getDiscountDescription() {
        return discountDescription;
    }
}
