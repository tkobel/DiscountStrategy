/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discount.strategy;

/**
 *
 * @author Tracy Kobel
 */
public class LineItem {
    private int qty;
    private Product product;

    public LineItem(int qty, Product product) {
        this.qty = qty;
        this.product = product;
    }
    
    public int getQty() {
        return qty;
    }

    public Product getProduct() {
        return product;
    }
}
