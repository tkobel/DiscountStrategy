package discount.strategy;

/**
 * An interface for DataAccess objects.
 * @author Tracy Kobel
 */
public interface IDataAccess {

    Customer getCustomerById(String id);
    Product getProductById(String id);
    
}
