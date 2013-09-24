package discount_strategy;

/**
 *
 * @author Tracy Kobel
 */
public class CashRegister {
    private Transaction currentTransaction;
    private DataAccess database;
    
    public CashRegister (DataAccess database) {
        this.database = database;
    }
    
    //Looks up customer by id and stores Customer object in the reciept
    public void startTransaction(String customerId) {
        currentTransaction = new Transaction(database.getCustomerById(customerId));
    }
    //Looks up product by id and sends quantity and product object to receipt
    public void scanProduct(int qty, String productId) {
        currentTransaction.addLineItem(qty, database.getProductById(productId));
    }
    
    public void generateReceipt() {
        ReceiptOutput receiptPrinter = new ConsoleReceiptOutput();
        receiptPrinter.generateReceipt(currentTransaction);
    };
    public void calculateTotal() {
        currentTransaction.calculateTotals();
    };    
}
