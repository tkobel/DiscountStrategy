package discount_strategy;

/**
 *
 * @author Tracy
 */
public class Receipt {
    private LineItem[] line;
    private Customer customer;
    
    public Receipt(Customer customer) {
    this.customer = customer;
    };
    
    public void addLineItem(int qty, Product item) {
        LineItem[] temp = new LineItem[line.length+1];
        System.arraycopy(line, 0, temp, 0, line.length);
        line[line.length-1] = new LineItem(qty, item);
    }
    public void generateReceipt() {
        //combine 
        //print receipt
    }
    
    private void 

}
