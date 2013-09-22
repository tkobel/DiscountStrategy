/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discount_strategy;

/**
 *
 * @author Tracy Kobel
 */
public class PercentDiscount implements Discount {
   
    private double discountPercentage;
    
    public PercentDiscount(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
    
    
}
