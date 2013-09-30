package discount.strategy;

/**
 * This class represents a line item for a transaction record. I a line item 
 * contains a quantity and a Product object.
 * @author Tracy Kobel
 */
public class LineItem {
    private int qty;
    private Product product;
    private static final String FIELD_ERR = "Field cannot be null";
    private static final String QTY_ERR = "Quantity must be greater than 0";

    /**
     * Custom Constructor. Requires a quantity and Product object.
     * @param qty total quantity of a single product for a transaction
     * @param product a Product object
     * @throws IllegalArgumentException if quantity is less than zero or product
     * object is null
     */
    public LineItem(int qty, Product product) {
        if(qty < 0) {
            throw new IllegalArgumentException(QTY_ERR);
        }
        this.qty = qty;
        if(product == null) {
            throw new IllegalArgumentException(FIELD_ERR);
        }
        this.product = product;
    }
    /**
     * Gets the quantity of items for this line
     * @return the quantity of items for this line
     */
    public int getQty() {
        return qty;
    }
    /**
     * Gets the Product object for this line
     * @return the Product object for this line
     */
    public Product getProduct() {
        return product;
    }
}
