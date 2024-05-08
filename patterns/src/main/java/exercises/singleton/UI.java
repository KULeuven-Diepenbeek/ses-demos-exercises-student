package exercises.singleton;

import java.util.List;

public class UI {
    private final ConfigurationManager config;
    private final List<UIWidget> widgets;

    public UI(ConfigurationManager config) {
        this.config = config;
        this.widgets = List.of(new UIWidget(config));
    }

    public void show() {
        for (UIWidget widget : widgets) {
            widget.show();
        }
    }
}
