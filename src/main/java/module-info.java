module calculatorapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens calculatorApp to javafx.fxml;
    exports calculatorApp;
}