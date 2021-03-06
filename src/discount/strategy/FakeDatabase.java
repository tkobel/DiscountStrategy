package discount.strategy;

/**
 * Simulates a database where arrays act as tables.
 * @author Tracy Kobel
 */
public class FakeDatabase {
        private Customer[] customerTable = {
        new Customer("110", "Tracy"), 
        new Customer("111", "Sue"),
        new Customer("185", "Jake"),
        new Customer("853", "Ellie"),
        new Customer("940", "Thomas"),
        new Customer("554", "Michelle")
    };

        private Product[] productTable = {
        new Product("STW-543", "Nike Shorts", 29.99, new PercentDiscount(.15)),
        new Product("AVN-803", "Blue Bath Towel", 8.49, new LotDiscount(3,20)),
        new Product("KLA-024", "Chaps Necktie", 18.99, new BOGODiscount()),
        new Product("IOD-798", "Mr Coffeemaker", 38.99, new PercentDiscount(.15)),
        new Product("LDK-354", "Tweed Socks", 12.55, new LotDiscount(2,22)),
        new Product("CNM-235", "Aztec Stoneware Plate", 14.89, new BOGODiscount()), 
        new Product("WEN-589", "Brewers MLB Jersey", 98.99, new PercentDiscount(.15)),
        new Product("JDE-493", "Maple Coaster", 4.99, new LotDiscount(4,17.49)),
        new Product("ERK-035", "Cloud Pillow", 10, new BOGODiscount()),
        new Product("VXC-320", "Keurig Variety Flavors", 8, new PercentDiscount(.15))
    };
    /**
    * Gets the Customer array which acts as a database.
    * @return an array of all Customers
    */
    public Customer[] getCustomerDatabase() {
        return customerTable;
    }
    /**
     * Gets the Product array which acts as a database.
     * @return an array of all Products
     */
    public Product[] getProductDatabase() {
        return productTable;
    }
}
