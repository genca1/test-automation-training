package automation.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("framework.properties")
public class ConfigurationProperties {

    @Value("${browser}")
    private String browser;

    @Value("${name}")
    private String name;

    @Value("${email}")
    private String email;

    public String getBrowser() {
        return browser;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
