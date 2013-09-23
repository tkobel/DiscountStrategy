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
        System.out.println("\nKohl's Receipt");
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
            System.out.printf("%3s %20s %-10s %-10s\n", line.getQty(), line.getProduct().getDescription() + " @",
                                 money.format(line.getProduct().getUnitPrice()),
                                money.format(line.getQty()*line.getProduct().getUnitPrice()));
            if(line.getProduct().getProductDiscount().getDiscountAmount(line) > 0) {
                System.out.printf("\t%-15s %15s\n", line.getProduct().getProductDiscount().getDiscountDescription(),
                                     money.format(-line.getProduct().getProductDiscount().getDiscountAmount(line)));
            }
        }
    }
    private void printTotals(Transaction trans) {
        System.out.println();
        System.out.printf("Subtotal%18s\n", money.format(trans.getSubtotal()));
        System.out.printf("Discount%18s\n", money.format(trans.getDiscountTotal()));
        System.out.printf("Tax%18s\n", money.format(trans.getTotalTax()));
        System.out.printf("Total%18s\n", money.format(trans.getTotal()));
    }
  
}
