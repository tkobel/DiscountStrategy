package discount_strategy;

/**
 *
 * @author Tracy Kobel
 */
public class ProductDatabase {
    Product[] productDatabase = {
        new Product("STW-543", "Nike Shorts", 29.99, new PercentDiscount(.15)),
        new Product("AVN-803", "Blue Bath Towel", 8.49, new QtyDiscount()),
        new Product("KLA-024", "Chaps Necktie", 18.99, new BOGODiscount()),
        new Product("IOD-798", "Mr Coffeemaker", 38.99, new PercentDiscount(.15)),
        new Product("LDK-354", "Tweed Socks", 12.55, new QtyDiscount()),
        new Product("CNM-235", "Aztec Stoneware Plate", 14.89, new BOGODiscount()), 
        new Product("WEN-589", "Brewers MLB Jersey", 98.99, new PercentDiscount(.15)),
        new Product("JDE-493", "Maple Coaster", 4.99, new QtyDiscount()),
        new Product("ERK-035", "Cloud Pillow", 10, new BOGODiscount()),
        new Product("VXC-320", "Keurig Variety Flavors", 8, new PercentDiscount(.15))
    };

    public Product[] getProductDatabase() {
        return productDatabase;
    }

}
