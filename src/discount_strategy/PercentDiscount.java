package discount_strategy;

import java.text.NumberFormat;

/**
 *
 * @author Tracy Kobel
 */
public class PercentDiscount implements Discount {
   
    private double discountPercentage;
    private String discountDescription;
    NumberFormat percent = NumberFormat.getPercentInstance();
    public PercentDiscount(double discountPercentage) {
        this.discountPercentage = discountPercentage;
        discountDescription = percent.format(discountPercentage) + " off";
    }
    
    @Override
    public double getDiscountAmount(LineItem ln) {
        return ln.getProduct().getUnitPrice() * discountPercentage * ln.getQty();
    }

    @Override
    public String getDiscountDescription() {
        return discountDescription;
    }  
}
