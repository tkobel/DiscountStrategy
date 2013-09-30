package discount.strategy;

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
    private double taxRate = .065;

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
    };
    /**
     * Adds a line item to the line item array
     * @param qty quantity to be added
     * @param item product to be added
     */
    public void addLineItem(int qty, Product item) {
        LineItem[] temp = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, temp, 0, lineItems.length);
        lineItems = temp;
        lineItems[lineItems.length-1] = new LineItem(qty, item);
    }    
/**
 * Calculates all transaction totals and stores them within the Transaction object
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
