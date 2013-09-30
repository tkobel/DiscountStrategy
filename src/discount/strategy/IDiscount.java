package discount.strategy;

/**
 *
 * @author Tracy Kobel
 */
public interface IDiscount {
    public abstract double getDiscountAmount(int qty, double price);
    public abstract String getDiscountDescription();
}
