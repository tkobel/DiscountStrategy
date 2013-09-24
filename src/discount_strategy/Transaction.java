package discount_strategy;

import java.util.Scanner;

/**
 *
 * @author Tracy
 */
public class Transaction {
    private Customer customer;
    private LineItem[] lineItems = {};
    private double subtotal;
    private double discountTotal;
    private double subtotalLessDiscount;
    private double totalTax;
    private double total;
    private static double taxRate = .065;
    Scanner keyboard = new Scanner(System.in);

    public LineItem[] getLineItems() {
        return lineItems;
    }
    public Customer getCustomer() {
        return customer;
    }
    public double getSubtotal() {
        return subtotal;
    }
    public double getDiscountTotal() {
        return discountTotal;
    }
    public double getSubtotalLessDiscount() {
        return subtotalLessDiscount;
    }
    public double getTotalTax() {
        return totalTax;
    }
    public double getTotal() {
        return total;
    }
    
    public static double getTaxRate() {
        return taxRate;
    }    
    
    public Transaction(Customer customer) {
    this.customer = customer;
    };
    
    public void addLineItem(int qty, Product item) {
        LineItem[] temp = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, temp, 0, lineItems.length);
        lineItems = temp;
        lineItems[lineItems.length-1] = new LineItem(qty, item);
    }    

    public void calculateTotals() {       
        calculateSubtotal();
        calculateDiscount();
        subtotalLessDiscount = subtotal - discountTotal;
        totalTax = subtotalLessDiscount * taxRate;
        total = subtotalLessDiscount + totalTax;
    }
    
    private void calculateSubtotal() {
        subtotal = 0;
        for(LineItem ln:lineItems) {
            subtotal += ln.getQty()* ln.getProduct().getUnitPrice();
        }
    }
    private void calculateDiscount() {
        discountTotal = 0;
        for(LineItem ln : lineItems) {
            discountTotal += ln.getProduct().getProductDiscount().getDiscountAmount(ln.getQty(), ln.getProduct().getUnitPrice());
        }
    }
}
