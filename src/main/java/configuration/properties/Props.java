package configuration.properties;

public class Props {
    private final static String COMMON_PROPERTIES_FILE = "common.properties";

    private static final PropertiesReader commonPropsReader = new PropertiesReader(COMMON_PROPERTIES_FILE);;

    public static String getApiUrl() {
        return commonPropsReader.getProperty("API_URL");
    }
}
