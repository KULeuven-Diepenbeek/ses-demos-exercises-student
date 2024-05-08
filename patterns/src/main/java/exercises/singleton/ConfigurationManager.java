package exercises.singleton;

import java.util.HashMap;
import java.util.Map;

public class ConfigurationManager {
    public static final
    ConfigurationManager INSTANCE =
            new ConfigurationManager();

    private Map<String, String> settings;

    private ConfigurationManager() {
        settings = new HashMap<>();
        loadSettings();
    }

    private void loadSettings() {
        // Simulate loading settings from a file or database
        settings.put("theme", "dark");
        settings.put("language", "en");
    }

    public String getSetting(String key) {
        return settings.getOrDefault(key, "Not Found");
    }

    public void updateSetting(String key, String value) {
        settings.put(key, value);
    }

    public void displaySettings() {
        settings.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}