package discount_strategy;

/**
 *
 * @author Tracy
 */
public class CashRegister {
    Transaction currentTransaction;
    DataAccess database = new DataAccess();
    
    //Looks up customer by id and stores Customer object in the reciept
    public void startTransaction(String customerId) {
        currentTransaction = new Transaction(database.getCustomerById(customerId));
    }
    //Looks up product by id and sends quantity and product object to receipt
    public void scanProduct(int qty, String productId) {
        currentTransaction.addLineItem(qty, database.getProductById(productId));
    }
    
    public void FinalizeTransaction(double amountTendered) {
        receivePayment(amountTendered);
        //print receipt
    };
    public void calculateTotal() {
        currentTransaction.calculateTotals();
        System.out.println("The total for this transaction is " + Double.toString(currentTransaction.getTotal()));
    };
    private void receivePayment(double amountTendered) {
        if(amountTendered < currentTransaction.getTotal()) {
            throw new IllegalArgumentException();
        }
    }
    
}
