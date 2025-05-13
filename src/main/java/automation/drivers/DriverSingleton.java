package automation.drivers;

import automation.drivers.strategy.DriverStrategyImplementer;
import automation.drivers.strategy.DriverStrategy;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class DriverSingleton {

    private static WebDriver driver;
    private static DriverSingleton instance = null;

    private DriverSingleton(String driver) {
        instantiate(driver);
    }

    public WebDriver instantiate(String strategy) {
        DriverStrategy driverStrategy = DriverStrategyImplementer.chooseStrategy(strategy);
        driver = driverStrategy.setStrategy();

        Duration duration = Duration.ofSeconds(5);
        driver.manage().timeouts().implicitlyWait(duration);
        driver.manage().window().maximize();

        return driver;
    }

    public static DriverSingleton getInstance(String driver) {
        if (instance == null) {
            instance = new DriverSingleton(driver);
        }

        return instance;
    }

    public static void closeObjectInstance() {
        instance = null;
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
