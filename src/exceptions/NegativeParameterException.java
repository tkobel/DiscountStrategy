package exceptions;

/**
 *
 * @author Tracy Kobel
 */
public class NegativeParameterException extends Exception {
    private static String NEGATIVE_ERR = "Parameter cannot be a negative integer";
    
    public NegativeParameterException() {
        super(NEGATIVE_ERR);
    }
    
    public NegativeParameterException(String msg) {
        super(msg);
    }
}
