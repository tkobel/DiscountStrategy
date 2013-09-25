package discount_strategy;

/**
 *
 * @author Tracy Kobel
 */
public interface IDataAccess {

    Customer getCustomerById(String id);
    Product getProductById(String id);
    
}
