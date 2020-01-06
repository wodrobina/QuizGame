package configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppProperties {

    private static volatile AppProperties INSTANCE;
    private static Properties applicationProperties = new Properties();

    private AppProperties() {
        loadProperties();
    }

    private static AppProperties getInstance() {
        if (INSTANCE == null) {
            synchronized (AppProperties.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AppProperties();
                }
            }
        }
        return INSTANCE;
    }

    public static String propertyOf(String propertyKey) {
        return getInstance().getProperties().getProperty(propertyKey);
    }

    private Properties getProperties() {
        return applicationProperties;
    }

    private void loadProperties() {
        try (InputStream propertiesStream = getClass().getClassLoader().getResourceAsStream("application.properties")) {
            if (propertiesStream != null) {
                applicationProperties.load(propertiesStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
