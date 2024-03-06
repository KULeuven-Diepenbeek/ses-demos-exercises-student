module be.kuleuven.darts {
    requires javafx.controls;
    requires javafx.fxml;
    requires be.kuleuven.scorebord;

    opens be.kuleuven.darts to javafx.fxml;
    exports be.kuleuven.darts;
}