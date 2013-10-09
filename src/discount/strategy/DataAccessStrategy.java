package discount.strategy;

/**
 * An interface for DataAccess objects. Allows for a connection to different 
 * types of data formats.
 * @author Tracy Kobel
 */
public interface DataAccessStrategy {

    /**
     * Gets a Customer object from an ID number.
     * @param id Customer ID number
     * @return the customer object with the corresponding ID number
     */
    public abstract Customer getCustomerById(String id);
    /**
     * Gets a Product object from an ID number.
     * @param id Product ID number
     * @return the Product object with the corresponding ID number
     */
    public abstract Product getProductById(String id);
    
}
