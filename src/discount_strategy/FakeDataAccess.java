package discount_strategy;

/**
 *
 * @author Tracy
 */
public class FakeDataAccess implements DataAccess {
    CustomerDatabase customerData = new CustomerDatabase();
    ProductDatabase productData = new ProductDatabase();
    
    @Override
    public Customer getCustomerById(String id) {
        for(Customer c : customerData.getCustomerDatabase()) {
            if(c.getId().equalsIgnoreCase(id)) {
                return c;
            }
        }
        return null;        
    };
    
    @Override
    public Product getProductById(String id) {
        for(Product p : productData.getProductDatabase()) {
            if(p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    };
}
