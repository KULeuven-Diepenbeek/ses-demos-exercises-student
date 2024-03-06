module be.kuleuven.darts {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens be.kuleuven.darts to javafx.fxml;
    exports be.kuleuven.darts;
}