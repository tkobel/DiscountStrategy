package discount_strategy;

/**
 *
 * @author Tracy Kobel
 */
public class Startup {
    public static void main(String[] args) {
        CashRegister cashRegister1 = new CashRegister();
        
        cashRegister1.startTransaction("110");
        cashRegister1.scanProduct(10, "ERK-035");
        cashRegister1.scanProduct(1, "WEN-589");
        cashRegister1.scanProduct(7, "AVN-803");
        cashRegister1.scanProduct(1, "LDK-354");
        cashRegister1.calculateTotal();
        cashRegister1.FinalizeTransaction(1000);
    }
        //Enter customer number to create reciept
    //add products to receipt
    //print receipt
}
