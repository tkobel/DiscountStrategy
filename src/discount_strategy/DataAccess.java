/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discount_strategy;

/**
 *
 * @author Tracy Kobel
 */
public interface DataAccess {

    Customer getCustomerById(String id);

    Product getProductById(String id);
    
}
