package exercises.singleton;

public class UIWidget {
    private final ConfigurationManager config;

    public UIWidget(ConfigurationManager config) {
        this.config = config;
    }
    public void show() {
        if (config.getSetting("theme").equals("dark")) {
            System.out.println("Showing dark UI widget");
        } else {
            System.out.println("Showing light UI widget");
        }
    }
}
