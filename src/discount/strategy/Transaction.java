package discount.strategy;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * This class holds all of the data for a single transaction. The data includes
 * a Customer object, any line items and all totals, taxes, and discounts.
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
    private double taxRate = .065;
    private static final String AMOUNT_ERR = "Amount must be greater than 0";
    private static final String FIELD_ERR = "Field cannot be null";
    private String dateFormat = "M/d/yyyy hh:mm a";
    private Calendar timeStamp = Calendar.getInstance();

    /**
     * Gets the array of Line Items
     * @return the array of Line Items
     */
    public LineItem[] getLineItems() {
        return lineItems;
    }
    /**
     * Gets the customer object.
     * @return the customer object
     */
    public Customer getCustomer() {
        return customer;
    }
    /**
     * Gets the subtotal amount.
     * @return transaction subtotal
     */
    public double getSubtotal() {
        return subtotal;
    }
    /**
     * Gets the total amount of discounts for the transaction.
     * @return transaction discount total
     */
    public double getDiscountTotal() {
        return discountTotal;
    }
    /**
     * Gets the subtotal minus the discount (before tax).
     * @return subtotal - all discounts
     */
    public double getSubtotalLessDiscount() {
        return subtotalLessDiscount;
    }
    /**
     * Gets the total amount of tax on for the transaction.
     * @return 
     */
    public double getTotalTax() {
        return totalTax;
    }
    /**
     * Gets the total amount due for the transaction
     * @return total amount due
     */
    public double getTotal() {
        return total;
    }
    /**
     * Gets the tax rate as a number between 0 and 1
     * @return the tax rate
     */
    public double getTaxRate() {
        return taxRate;
    }    
    /**
     * Custom Constructor. Requires a customer object.
     * @param customer a customer object
     */
    public Transaction(Customer customer) {
    this.customer = customer;
    }
    /**
     * Gives the transaction time as a string
     * @return a formatted string of the current transaction date and time
     */
    public String dateToString() {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(timeStamp.getTime());
    }
    /**
     * Adds a line item to the line item array
     * @param qty quantity to be added
     * @param item product to be added
     * @throws IllegalArgumentException if qty is less than 0 or item is null
     */
    public void addLineItem(int qty, Product item) throws IllegalArgumentException {
        if (qty < 0) {
            throw new IllegalArgumentException(AMOUNT_ERR);
        }
        if (item == null) {
            throw new IllegalArgumentException(FIELD_ERR);
        }
        LineItem[] temp = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, temp, 0, lineItems.length);
        lineItems = temp;
        lineItems[lineItems.length-1] = new LineItem(qty, item);
    }    
/**
 * Calculates all transaction totals and stores them within the Transaction 
 * object
 */
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
