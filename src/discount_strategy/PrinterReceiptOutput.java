package discount_strategy;

import java.text.NumberFormat;


/**
 *
 * @author Tracy Kobel
 */
public class PrinterReceiptOutput implements ReceiptOutput {
    
    NumberFormat money = NumberFormat.getCurrencyInstance();
    NumberFormat percent = NumberFormat.getPercentInstance();
    
    @Override
    public void generateReceipt(Transaction trans) {
        printCustomer(trans.getCustomer());
        printLineItems(trans.getLineItems());
        printTotals(trans);
    }
    private void printCustomer(Customer customer) {
        System.out.println("Welcome " + customer.getName());
        System.out.println("Your customer number is: " + customer.getId());
    }
    private void printLineItems(LineItem[] lineItems) {
        for(LineItem line : lineItems) {
            System.out.println(line.getQty() + " " + line.getProduct().getDescription()
                                + " @ " + money.format(line.getProduct().getUnitPrice())
                                + "\t" + money.format(line.getQty()*line.getProduct().getUnitPrice()));
            if(line.getProduct().getProductDiscount().getDiscountAmount(line) > 0) {
                System.out.println("\t" + line.getProduct().getProductDiscount().getDiscountDescription()
                                    + "\t" + money.format(line.getProduct().getProductDiscount().getDiscountAmount(line)));
            }
        }
    }
    private void printTotals(Transaction trans) {
        System.out.println("Subtotal\t" + money.format(trans.getSubtotal()));
        System.out.println("You saved \t" + money.format(trans.getDiscountTotal()) + "!");
        System.out.println("Tax\t\t" + money.format(trans.getTotalTax()));
        System.out.println("Total\t\t" + money.format(trans.getTotal()));
    }
  
}
