package discount.strategy;

/**
 * This class simulates product data.  It stores a product ID number, a brief 
 * product description, the unit price, and a discount object associated with
 * a product
 * @author Tracy Kobel
 */
public class Product {
    
    private String id;
    private String description;
    private double unitPrice;
    private DiscountStrategy productDiscount;
    private static final String AMOUNT_ERR = "Amount must be greater than 0";
    private static final String FIELD_ERR = "Field cannot be null";
    /**
     * Custom Constructor, requires product ID, description, unit price and a
     * Discount object
     * @param id the product ID number
     * @param description A brief description of the product
     * @param unitPrice the price of 1 unit
     * @param productDiscount a Discount object
     * @throws IllegalArgumentException if id, description, or productDiscount
     * is null, or if unitPrice is less than 0
     */
    
    public Product(String id, String description, double unitPrice, DiscountStrategy productDiscount) 
            throws IllegalArgumentException {
        if(id == null) {
            throw new IllegalArgumentException(FIELD_ERR);
        }
        this.id = id;
        if(description == null) {
            throw new IllegalArgumentException(FIELD_ERR);
        }
        this.description = description;
        if(unitPrice < 0) {
            throw new IllegalArgumentException(AMOUNT_ERR);
        }
        this.unitPrice = unitPrice;
        if(productDiscount == null) {
            throw new IllegalArgumentException(FIELD_ERR);
        }
        this.productDiscount = productDiscount;
    }

    /**
     * Gets the Product ID number
     * @return the Product ID number
     */
    public String getId() {
        return id;
    }

    /**
     * Gets a brief description of the product
     * @return a brief description of the product
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the list price for 1 unit of the product
     * @return the price for 1 unit of the product
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * Gets the Discount object associated with this product
     * @return the Discount object for this product
     */
    public DiscountStrategy getProductDiscount() {
        return productDiscount;
    } 
}
