package discount.strategy;
import java.text.NumberFormat;

/**
 * An implementation of the IReceiptOutput interface. Outputs a receipt to the
 * java console
 * @author Tracy Kobel
 */
public class ConsoleReceiptOutput implements IReceiptOutput {
    
    private NumberFormat money = NumberFormat.getCurrencyInstance();
    private static final String TRANSACTION_ERR = "Transaction object is null";
    /**
     * Prints receipt to the java console
     * @param trans transaction object customer purchase data
     * @throws IllegalArgumentException if transaction object is null
     */
    @Override
    public void generateReceipt(Transaction trans) {
        if (trans == null) {
            throw new IllegalArgumentException(TRANSACTION_ERR);
        }
        System.out.println("               Kohl's Receipt");
        printCustomer(trans);
        System.out.println();
        printLineItems(trans);
        printTotals(trans);
    }
    private void printCustomer(Transaction trans) {
        if (trans == null) {
            throw new IllegalArgumentException(TRANSACTION_ERR);
        }
        System.out.println("Welcome " + trans.getCustomer().getName());
        System.out.println("Your customer number is: " + trans.getCustomer().getId());
    }
    private void printLineItems(Transaction trans) {
        if (trans == null) {
            throw new IllegalArgumentException(TRANSACTION_ERR);
        }
        System.out.printf("%3s %-20s %10s %10s\n", "Qty", "Description", "Unit Price", "Ext Price");
        System.out.println("----------------------------------------------");
        for(LineItem line : trans.getLineItems()) {
            
            System.out.printf("%3s %-20s %10s %10s\n", line.getQty(), line.getProduct().getDescription() + " @",
                                     money.format(line.getProduct().getUnitPrice()),
                                     money.format(line.getQty()*line.getProduct().getUnitPrice()));
            if(line.getProduct().getProductDiscount().getDiscountAmount(line.getQty(), line.getProduct().getUnitPrice()) > 0) {
                System.out.printf("\t%-28s %10s\n", line.getProduct().getProductDiscount().getDiscountDescription(),
                                     money.format(-line.getProduct().getProductDiscount().getDiscountAmount(line.getQty(), line.getProduct().getUnitPrice())));
            }
        }
    }
    private void printTotals(Transaction trans) {
        if (trans == null) {
            throw new IllegalArgumentException(TRANSACTION_ERR);
        }
        System.out.println();
        System.out.printf("%35s %10s\n", "Subtotal", money.format(trans.getSubtotal()));
        System.out.printf("%35s %10s\n", "Discount", money.format(-trans.getDiscountTotal()));
        System.out.printf("%35s %10s\n", "Tax",      money.format(trans.getTotalTax()));
        System.out.printf("%35s %10s\n", "Total",    money.format(trans.getTotal()));
    }
}
