package discount.strategy;

/**
 * An implementation of the DataAccessStrategy interface. Used to simulate accessing a
 * database by getting data from another java class.
 * @author Tracy
 */
public class FakeDataAccess implements DataAccessStrategy {
    private FakeDatabase fakeData = new FakeDatabase();
    private final String NAME_ERR = "Name cannot be null";
    private final String PRODUCT_ERR ="Product cannot be null";
    
    /**
     * Gets a Customer object from an ID number.
     * @param id Customer ID number
     * @return the customer object with the corresponding ID number
     * @throws IllegalArgumentException if Customer ID number is null
     */
    @Override
    public Customer getCustomerById(String id) {
        if(id == null) {
            throw new IllegalArgumentException(NAME_ERR);
        }
        for(Customer c : fakeData.getCustomerDatabase()) {
            if(c.getId().equalsIgnoreCase(id)) {
                return c;
            }
        }
        return null;        
    };
    
    /**
     * Gets a Product object from an ID number.
     * @param id Product ID number
     * @return the Product object with the corresponding ID number
     * @throws IllegalArgumentException if the Product ID is null
     */
    @Override
    public Product getProductById(String id) {
        if(id == null) {
            throw new IllegalArgumentException(PRODUCT_ERR);
        }
        for(Product p : fakeData.getProductDatabase()) {
            if(p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    };
}
