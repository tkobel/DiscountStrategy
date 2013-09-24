package discount_strategy;

/**
 *
 * @author Tracy Kobel
 */
public class CustomerDatabase {
    private Customer[] customerDatabase = {
        new Customer("110", "Tracy"), 
        new Customer("111", "Sue"),
        new Customer("185", "Jake"),
        new Customer("853", "Ellie"),
        new Customer("940", "Thomas"),
        new Customer("554", "Michelle")
    };

    public Customer[] getCustomerDatabase() {
        return customerDatabase;
    }
}
