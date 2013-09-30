package discount.strategy;
/**
 * This class simulates a customer object. It holds the customer name and an ID
 * number.
 * @author Tracy Kobel 
 */
public class Customer {
    private String id;
    private String name;
    private final String ID_ERR = "Invalid customer ID";
    private final String NAME_ERR = "Name cannot be null";

    /**
     * Sets the customer id value.
     * @param name -an alphanumeric value
     * @throws IllegalArgumentException if custId is null or == 0
     */
    public final void setName(String name) {
        if(name ==  null|| name.length() == 0) {
            throw new IllegalArgumentException(NAME_ERR);
        }
        this.name = name;
    }
    /**
     *Gets the customer ID number
     * @return the customer ID
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the customer name
     * @return the customer name
     */
    public String getName() {
        return name;
    }
    /**
     * Custom Constructor. Requires a name and ID
     * @param id customer ID number must be 3 digits
     * @param name customer name
     * @throws IllegalArgumentException if id is null or length is not 3
     */
    public Customer(String id, String name) {
        if (id == null || id.length() != 3) {
            throw new IllegalArgumentException(ID_ERR);
        }
        this.id = id;
        setName(name);
    }
}
