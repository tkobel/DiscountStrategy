package discount_strategy;

/**
 *
 * @author Tracy Kobel
 */
public interface Discount {
    public abstract double getDiscountAmount(LineItem line);
}
