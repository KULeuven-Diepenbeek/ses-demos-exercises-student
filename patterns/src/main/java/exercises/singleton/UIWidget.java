package exercises.singleton;

public class UIWidget {

    public UIWidget() {
    }
    public void show() {
        if (ConfigurationManager.INSTANCE
                .getSetting("theme").equals("dark")) {
            System.out.println("Showing dark UI widget");
        } else {
            System.out.println("Showing light UI widget");
        }
    }
}
