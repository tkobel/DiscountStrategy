package discount_strategy;

/**
 *
 * @author Tracy
 */
public class CashRegister {
    Receipt thisOrderReceipt;
    public void startTransaction(String customerId) {
        DataAccess lookupCustomer = new CustomerDatabase();
        thisOrderReceipt = new Receipt(lookupCustomer.getDatabaseObject(customerId));
    }
}
