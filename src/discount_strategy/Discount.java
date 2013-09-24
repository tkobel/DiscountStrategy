package discount_strategy;

/**
 *
 * @author Tracy Kobel
 */
public interface Discount {
    public abstract double getDiscountAmount(int qty, double price);
    public abstract String getDiscountDescription();
}
