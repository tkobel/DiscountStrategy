package discount.strategy;

/**
 * This is the Startup program for the Discount Strategy project.
 * @author Tracy Kobel
 * @version 1.00
 */
public class Startup {
    public static void main(String[] args) {
        
        CashRegister cashRegister1 = new CashRegister(DataAccessFactory
                .getInstance()
                .getDataAccessStrategy(DataAccessFactory.DataAccessStrategies.FAKE_DATA_ACCESS));
        
        cashRegister1.startTransaction("110");
        cashRegister1.scanProduct(10, "ERK-035");
        cashRegister1.scanProduct(1, "WEN-589");
        cashRegister1.scanProduct(7, "AVN-803");
        cashRegister1.scanProduct(1, "LDK-354");
        cashRegister1.calculateTotal();
        cashRegister1.generateReceipt();
    }
}
