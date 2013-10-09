package discount.strategy;

/**
 * This class simulates a cash register. Delegates responsibilities for 
 * processing transactions.
 * @author Tracy Kobel
 */
public class CashRegister {
    private Transaction currentTransaction;
    private DataAccessStrategy database; 
    private static final String DATA_ACCESS_ERR = "Data access connection is "
            + "null";
    private static final String FIELD_ERR = "Field cannot be null";
    private static final String QTY_ERR = "Quantity must be greater than 0";
   /**
    * Custom constructor requires an DataAccessStrategy implementation to access
    * customer and product data.
    * @param database connection to customer and product database
    * @throws IllegalArgumentException when DataAccess is null
    */
    public CashRegister (DataAccessStrategy database) {
        if (database == null) {
            throw new IllegalArgumentException(DATA_ACCESS_ERR);
        }
        this.database = database;
    }
   /**
    * Starts a new transaction. Requires a customer number.
    * @param customerId customer ID number
    * @throws IllegalArgumentException when customerId is null.
    */
    public void startTransaction(String customerId) {
        if (customerId == null) {
            throw new IllegalArgumentException(FIELD_ERR);
        }
        currentTransaction = new Transaction(database.getCustomerById(customerId));
    }

   /**
    * Add new line item to the transaction.
    * @param qty quantity
    * @param productId product ID
    * @throws IllegalArgumentException when qty is less than 0 or product ID is
    * null.
    */
    public void scanProduct(int qty, String productId) {
        if (qty < 0) {
            throw new IllegalArgumentException(QTY_ERR);
        }
        if (productId == null){
            throw new IllegalArgumentException(FIELD_ERR);
        }
        currentTransaction.addLineItem(qty, database.getProductById(productId));
    }
    
    /**
     * Generates a receipt of this transaction.
     */
    public void generateReceipt() {
        ReceiptOutputStrategy receiptPrinter = new ConsoleReceiptOutput();
        receiptPrinter.generateReceipt(currentTransaction);
    };
    /**
     * Calculates the totals for this transaction.
     */
    public void calculateTotal() {
        currentTransaction.calculateTotals();
    };    
}
