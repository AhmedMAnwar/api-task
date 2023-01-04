package prop;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class PropertyFileLoader {

    private final static String urlPath = "/config/config.properties";
    private final Properties properties;

    public PropertyFileLoader() throws IOException {
        URL url = PropertyFileLoader.class.getResource(urlPath);
        InputStream inputStream = new FileInputStream(url.getPath());
        this.properties = new Properties();
        properties.load(inputStream);
    }

    public String getBaseURL() {
        return properties.getProperty("BASE_URL");
    }

    public String getProductURL() {
        return properties.getProperty("PRODUCT_URL");
    }

    public String readAllProduct() {
        return properties.getProperty("READ_ALL_PRODUCT");
    }

    public String readOneProduct() {
        return properties.getProperty("READ_ONE_PRODUCT");
    }

    public String createNewProduct() {
        return properties.getProperty("CREATE_NEW_PRODUCT");
    }

    public String updateProduct() {
        return properties.getProperty("UPDATE_PRODUCT");
    }

    public String deleteProduct() {
        return properties.getProperty("DELETE_PRODUCT");
    }

    public String getCategroyURL() {
        return properties.getProperty("CATEGORY_URL");
    }

    public String readAllCategroy() {
        return properties.getProperty("READ_ALL_CATEGORY");
    }
}
