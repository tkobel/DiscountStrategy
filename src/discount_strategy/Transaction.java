package discount_strategy;
/**
 *
 * @author Tracy
 */
public class Transaction {
    private LineItem[] line;
    private Customer customer;
    private double subtotal;
    private double discountTotal;
    private double total;

    public double getTotal() {
        return total;
    }
    private static final double TAX_RATE = .065;
    
    public Transaction(Customer customer) {
    this.customer = customer;
    };
    
    public void addLineItem(int qty, Product item) {
        LineItem[] temp = new LineItem[line.length+1];
        System.arraycopy(line, 0, temp, 0, line.length);
        line[line.length-1] = new LineItem(qty, item);
    }
    
//    private void printCustomer() {
//        System.out.println("Welcome " + customer.getName());
//        System.out.println("Your customer number is: " + customer.getId());
//    }
//    private void printLineItems() {
//        for(LineItem l : line) {
//            System.out.println(l.getQty() + " " + l.getProduct().getDescription()
//                                + "\t\t" + Double.toString(l.getProduct().getUnitPrice()));
//            //print discount line
//        }
//    }
    public void calculateTotals() {       
        calculateSubtotal();
        calculateDiscount();
        total = 0;
        total = subtotal - discountTotal;
        total += total*TAX_RATE;
    }
    
    private void calculateSubtotal() {
        subtotal = 0;
        for(LineItem ln:line) {
            subtotal += ln.getQty()* ln.getProduct().getUnitPrice();
        }
    }
    private void calculateDiscount() {
        discountTotal = 0;
        for(LineItem ln : line) {
            discountTotal += ln.getProduct().getProductDiscount().getDiscountAmount(ln);
        }
    }
}
