package discount.strategy;

/**
 * An interface for ReceiptOutput objects. Implementations allow for receipts to
 * be generated for various formats of output.
 * @author Tracy Kobel
 */
public interface ReceiptOutputStrategy {
    /**
     * Generates a record of a transaction to a form of output.
     * @param trans the transaction object to be recorded
     */
    public abstract void generateReceipt(Transaction trans);
}
