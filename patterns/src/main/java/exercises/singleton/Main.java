package exercises.singleton;

public class Main {
    public static void main(String[] args) {
        ConfigurationManager config = new ConfigurationManager();
        UI ui = new UI(config);
        ui.show();
    }
}
