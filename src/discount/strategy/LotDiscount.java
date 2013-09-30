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
    private static final String AMOUNT_ERR = "Amount must be greater than 0";
    /**
     * Custom Constructor. Requires the size of the lot and the total price for
     * the lot
     * @param qtyRequired size of lot for discount
     * @param discountedPriceForLot price for the lot
     * @throws IllegalArgumentException if quantityRequired or 
     * discountedPriceForLot is less than 0
     */
    public LotDiscount(int qtyRequired, double discountedPriceForLot) {
        if(qtyRequired < 0) {
            throw new IllegalArgumentException(AMOUNT_ERR);
        }
        this.qtyRequired = qtyRequired;
        if(discountedPriceForLot < 0) {
            throw new IllegalArgumentException(AMOUNT_ERR);
        }
        this.discountedPriceForLot = discountedPriceForLot;
        discountDescription = Integer.toString(qtyRequired) + " for "
                                         + money.format(discountedPriceForLot);
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
        double regPriceForLot = qty * price;
        double differenceOfRegLotAndDiscountedLot = regPriceForLot - discountedPriceForLot;      
        return (qty/qtyRequired) * differenceOfRegLotAndDiscountedLot;
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
