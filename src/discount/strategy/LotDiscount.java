package discount.strategy;

import java.text.NumberFormat;

/**
 * An implementation of the IDiscount interface. Used for getting a discounted
 * price on items sold as a lot.
 * @author Tracy Kobel
 */
public class LotDiscount implements IDiscount {   
    private int qtyRequired;
    private double discountedPriceForLot;
    private String discountDescription;
    private NumberFormat money = NumberFormat.getCurrencyInstance();
    /**
     * Custom Constructor. Requires the size of the lot and the total price for
     * the lot
     * @param qtyRequired size of lot for discount
     * @param discountedPriceForLot price for the lot
     */
    public LotDiscount(int qtyRequired, double discountedPriceForLot) {
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
