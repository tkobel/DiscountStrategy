package discount_strategy;

/**
 *
 * @author Tracy
 */
public class CashRegister {
    Receipt thisOrderReceipt;
    DataAccess database = new DataAccess();
    
    //Looks up customer by id and stores Customer object in the reciept
    public void startTransaction(String customerId) {
        thisOrderReceipt = new Receipt(database.getCustomerById(customerId));
    }
    
    //Looks up product by id and sends quantity and product object to receipt
    public void scanProduct(int qty, String productId) {
        thisOrderReceipt.addLineItem(qty, database.getProductById(productId));
    }
    
    public void totalSale(){};
    public void printReceipt(){};
}
