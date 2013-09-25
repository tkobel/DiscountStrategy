package discount_strategy;

import java.text.NumberFormat;


/**
 *
 * @author Tracy Kobel
 */
public class ConsoleReceiptOutput implements IReceiptOutput {
    
    private NumberFormat money = NumberFormat.getCurrencyInstance();
    private String receiptTitle = "               Kohl's Receipt";
    private String msgWelcome = "Welcome ";
    private String msgCustomerId = "Your customer number is: ";
    private String msgSubtotal = "Subtotal";
    private String msgDiscount = "Discount";
    private String msgTax = "Tax";
    private String msgTotal = "Total";
    private String msgQty = "Qty";
    private String msgDescription = "Description";
    private String msgUnitPrice = "Unit Price";
    private String msgExtendedPrice ="Ext Price";
    private String receiptDivider = "----------------------------------------------";
    
    
    @Override
    public void generateReceipt(Transaction trans) {
        System.out.println(receiptTitle);
        printCustomer(trans);
        System.out.println();
        printLineItems(trans);
        printTotals(trans);
    }
    private void printCustomer(Transaction trans) {
        System.out.println(msgWelcome + trans.getCustomer().getName());
        System.out.println(msgCustomerId + trans.getCustomer().getId());
    }
    private void printLineItems(Transaction trans) {
        System.out.printf("%3s %-20s %10s %10s\n", msgQty, msgDescription, msgUnitPrice, msgExtendedPrice);
        System.out.println(receiptDivider);
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
        System.out.println();
        System.out.printf("%35s %10s\n", msgSubtotal, money.format(trans.getSubtotal()));
        System.out.printf("%35s %10s\n", msgDiscount, money.format(-trans.getDiscountTotal()));
        System.out.printf("%35s %10s\n", msgTax,      money.format(trans.getTotalTax()));
        System.out.printf("%35s %10s\n", msgTotal,    money.format(trans.getTotal()));
    }
}
