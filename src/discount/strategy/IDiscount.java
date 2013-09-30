package discount.strategy;

/**
 * An interface for Discount objects. Allows for different types of discounts to
 * be interchangeable. Each implementation calculates a discount differently 
 * using a quantity and unit price.
 * @author Tracy Kobel
 */
public interface IDiscount {
    /**
     * Gets the amount to discount off of the extended price for the given
     * quantity and unit price
     * @param qty total quantity of a single item in a transaction
     * @param price list price for 1 unit of the product to be discounted
     * @return the amount to be subtracted from the extended price
     */
    public abstract double getDiscountAmount(int qty, double price);
    /**
     * Gets a description of discount
     * @return a description of the discount
     */
    public abstract String getDiscountDescription();
}
