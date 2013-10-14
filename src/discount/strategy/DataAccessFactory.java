package discount.strategy;

/**
 * A factory for creating Data Access Strategies.
 * @author Tracy Kobel
 */
public class DataAccessFactory {
    public static enum DataAccessStrategies {
        FAKE_DATA_ACCESS
    }
    
    private static DataAccessFactory instance;
    private DataAccessFactory() {
    }
    
    public static DataAccessFactory getInstance() {
        if (instance == null) {
            instance = new DataAccessFactory();
        }
        return instance;
    }
    /**
     * Creates a data access strategy based on a type passed as an enum.
     * @param strategy the type of data access strategy to be used
     * @return a data access strategy object
     */
    public DataAccessStrategy getDataAccessStrategy(DataAccessStrategies strategy) {
        DataAccessStrategy dataAccessStrategy = null;
        switch(strategy) {
            case FAKE_DATA_ACCESS: {
                dataAccessStrategy = new FakeDataAccess();
                break;
            }              
        }
        return dataAccessStrategy;
    }
}
