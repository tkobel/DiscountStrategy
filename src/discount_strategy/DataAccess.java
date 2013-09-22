package discount_strategy;

/**
 *
 * @author Tracy
 */
public class DataAccess {
    CustomerDatabase customerData = new CustomerDatabase();
    ProductDatabase productData = new ProductDatabase();
    
    public Customer getCustomerById(String id) {
        for(Customer c : customerData.getCustomerDatabase()) {
            if(c.getId().equalsIgnoreCase(id)) {
                return c;
            }
        }
        return null;
    };
    
    public Product getProductById(String id) {
        for(Product p : productData.getProductDatabase()) {
            if(p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }
}
