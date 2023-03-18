package HhClasses;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfProperties {

    public static FileInputStream fileInputStream;
    public static Properties PROPERTIES;

    static {
        try {
            fileInputStream = new FileInputStream("/home/palam/IdeaProjects/SearchingJobScript/src/test/java" +
                    "/resources/conf.properties");
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
//    protected static String setProperty(String key) {return .setProperty(key);}
}
