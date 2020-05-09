package configuration.properties;

import lombok.extern.log4j.Log4j;

import java.util.Optional;
import java.util.Properties;

@Log4j
public class PropertiesReader {
    private final static String PROPERTIES_FOLDER_PATH = "properties/";

    private final Properties props;

    public PropertiesReader(String propertiesFileName) {
        props = new Properties();
        try {
            String filePath = PROPERTIES_FOLDER_PATH + propertiesFileName;
            props.load(
                Optional.ofNullable(
                    getClass()
                        .getClassLoader()
                        .getResourceAsStream(filePath)
                ).orElseThrow(() -> new RuntimeException("Failed to get input stream for file: " + filePath)));
        } catch (Exception e) {
            log.error("Failed to load properties file");
            throw new RuntimeException(e);
        }
    }

    public String getProperty(String key) {
        return props.getProperty(key);
    }
}
