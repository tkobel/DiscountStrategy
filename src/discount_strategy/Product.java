package discount_strategy;

/**
 *
 * @author Tracy Kobel
 */
public class Product {
    
    private String id;
    private String description;
    private double unitPrice;
    private IDiscount productDiscount;
    
    public Product(String id, String description, double unitPrice, IDiscount productDiscount) {
        this.id = id;
        this.description = description;
        this.unitPrice = unitPrice;
        this.productDiscount = productDiscount;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public IDiscount getProductDiscount() {
        return productDiscount;
    } 
}
