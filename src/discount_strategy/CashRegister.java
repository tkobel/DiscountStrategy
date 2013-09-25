package discount_strategy;

/**
 *
 * @author Tracy Kobel
 */
public class CashRegister {
    private Transaction currentTransaction;
    private IDataAccess database;
    
    public CashRegister (IDataAccess database) {
        this.database = database;
    }
    
    public void startTransaction(String customerId) {
        currentTransaction = new Transaction(database.getCustomerById(customerId));
    }

    public void scanProduct(int qty, String productId) {
        currentTransaction.addLineItem(qty, database.getProductById(productId));
    }
    
    public void generateReceipt() {
        IReceiptOutput receiptPrinter = new ConsoleReceiptOutput();
        receiptPrinter.generateReceipt(currentTransaction);
    };
    public void calculateTotal() {
        currentTransaction.calculateTotals();
    };    
}
