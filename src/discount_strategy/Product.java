package discount_strategy;

/**
 *
 * @author Tracy Kobel
 */
public class Product {
    
    private String productId;
    private String description;
    private double unitPrice;
    private Discount productDiscount;
    
    public Product(String productId, String description, double unitPrice, Discount productDiscount) {
        this.productId = productId;
        this.description = description;
        this.unitPrice = unitPrice;
        this.productDiscount = productDiscount;
    }

    
}
