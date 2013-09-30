package discount.strategy;

/**
 *
 * @author Tracy Kobel
 */
public interface IReceiptOutput {
    public abstract void generateReceipt(Transaction trans);
}
