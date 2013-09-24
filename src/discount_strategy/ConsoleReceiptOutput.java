package discount_strategy;

import java.text.NumberFormat;


/**
 *
 * @author Tracy Kobel
 */
public class ConsoleReceiptOutput implements ReceiptOutput {
    
    private NumberFormat money = NumberFormat.getCurrencyInstance();
    private String receiptTitle = "Kohl's Receipt";
    
    
    @Override
    public void generateReceipt(Transaction trans) {
        System.out.println(receiptTitle);
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
            
            System.out.printf("%3s %-20s %10s %10s\n", line.getQty(), line.getProduct().getDescription() + " @",
                                 money.format(line.getProduct().getUnitPrice()),
                                money.format(line.getQty()*line.getProduct().getUnitPrice()));
            if(line.getProduct().getProductDiscount().getDiscountAmount(line.getQty(), line.getProduct().getUnitPrice()) > 0) {
                System.out.printf("\t%-15s %15s\n", line.getProduct().getProductDiscount().getDiscountDescription(),
                                     money.format(-line.getProduct().getProductDiscount().getDiscountAmount(line.getQty(), line.getProduct().getUnitPrice())));
            }
        }
    }
    private void printTotals(Transaction trans) {
        System.out.println();
        System.out.printf("%-8s %18s\n", "Subtotal", money.format(trans.getSubtotal()));
        System.out.printf("%-8s %18s\n", "Discount", money.format(trans.getDiscountTotal()));
        System.out.printf("%-8s %18s\n", "Tax", money.format(trans.getTotalTax()));
        System.out.printf("%-8s %18s\n", "Total", money.format(trans.getTotal()));
    }
  
}
