package drivers.strategy;

public class DriverStrategyImplementer {

    public static DriverStrategy chooseStrategy(String strategy) {
        switch (strategy) {
            case "CHROME":
                return new Chrome();
            default:
                return null;
        }
    }
}
