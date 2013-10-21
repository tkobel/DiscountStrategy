package discount.strategy;

/**
 * This is the Startup program for the Discount Strategy project.
 * @author Tracy Kobel
 * @version 1.00
 */
public class Startup {
    public static void main(String[] args) {
        
        DataAccessStrategy dataAccess = DataAccessFactory
                                        .getInstance()
                                        .getDataAccessStrategy(DataAccessFactory.DataAccessStrategies.FAKE_DATA_ACCESS);
        
        CashRegister cr = new CashRegister(dataAccess);
        
        cr.startTransaction("110");  
        cr.scanProduct(10, "ERK-035");
        cr.scanProduct(1, "WEN-589");
        cr.scanProduct(7, "AVN-803");
        cr.scanProduct(1, "LDK-354");
        cr.calculateTotal();
        cr.generateReceipt();
    }
}
