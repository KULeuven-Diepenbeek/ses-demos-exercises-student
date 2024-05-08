package exercises.singleton;

import java.util.List;

public class UI {
    private final List<UIWidget> widgets;

    public UI() {
        this.widgets = List.of(new UIWidget());
    }

    public void show() {
        for (UIWidget widget : widgets) {
            widget.show();
        }
    }
}
