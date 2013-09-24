package discount_strategy;

/**
 * This
 * @author Tracy Kobel
 * @version 1.00
 */

public class Customer {
    private String id;
    private String name;

    /**
     * Sets the customer id value
     * @param name -an alphanumeric value
     * @throws IllegalArgumentException if custId is null or == 0
     */
    public void setName(String name) {
        if(name ==  null|| name.length() == 0) {
            throw new IllegalArgumentException("name is required");
        }
        this.name = name;
    }

    /**
     * 
     * @return the customer id
     */
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
