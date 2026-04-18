package org.discord;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    public static String getToken() {
        Properties prop = new Properties();

        try (InputStream input = Config.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.err.println("Fehler: config.properties wurde nicht im resources-Ordner gefunden!");
                return null;
            }
            prop.load(input);
            return prop.getProperty("bot.token");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
