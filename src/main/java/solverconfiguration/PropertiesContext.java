package solverconfiguration;

import java.io.*;
import java.util.Properties;

public class PropertiesContext {
    private static Properties properties;

    static {
        properties = new Properties();
        String path = System.getProperty("user.dir");
        String propertiesLocation = path + File.separator + "src" + File.separator + "main" + File.separator + "resources\\configuration.properties";
        try {
            //字节流不识别中文，所以这里有字符流
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(propertiesLocation));
            properties.load(new InputStreamReader(in, "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key) {
        return (String) properties.get(key);
    }
}
