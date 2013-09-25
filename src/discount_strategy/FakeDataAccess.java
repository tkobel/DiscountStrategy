package discount_strategy;

/**
 *
 * @author Tracy
 */
public class FakeDataAccess implements IDataAccess {
    private FakeDatabase fakeData = new FakeDatabase();
    
    @Override
    public Customer getCustomerById(String id) {
        for(Customer c : fakeData.getCustomerDatabase()) {
            if(c.getId().equalsIgnoreCase(id)) {
                return c;
            }
        }
        return null;        
    };
    
    @Override
    public Product getProductById(String id) {
        for(Product p : fakeData.getProductDatabase()) {
            if(p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    };
}
