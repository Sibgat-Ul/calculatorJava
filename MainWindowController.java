package Calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainWindowController {
    @FXML private Pane titlePane;
    @FXML private ImageView btnMinimize, btnClose;
    @FXML private Label dis, preDis;

    private double x, y, doti;
    private double num, num1, num2, onClear;
    private String operator = "";

    public void initialize(Stage stage) {
        titlePane.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });

        titlePane.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX()-x);
            stage.setY(mouseEvent.getScreenY()-y);
        });

        btnClose.setOnMouseClicked(mouseEvent -> stage.close());
        btnMinimize.setOnMouseClicked(mouseEvent -> stage.setIconified(true));

        dis.setText(String.valueOf(0));
        preDis.setText(String.valueOf(0));
    }

    @FXML
    void onNumberClick(MouseEvent event) {
        String val = dis.getText();
        String nums = ((Pane)event
                .getSource())
                .getId()
                .replace("btn","");

        String d = nums.equals("Dot") ? "." : nums;

        dis.setText(dis.getText()+d);
    }

    @FXML
    void onSymbolClick(MouseEvent event) {
        String symbol = ((Pane)event.getSource()).getId().replace("btn","");
        if(symbol.equals("SqRoot")) {
            double sroot = Math.sqrt(Double.parseDouble(dis.getText()));
            num1 = sroot;
            dis.setText(String.valueOf(sroot));
        } else if(symbol.equals("CbRoot")) {
            double croot = Math.cbrt(Double.parseDouble(dis.getText()));
            num1 = croot;
            dis.setText(String.valueOf(croot));
        } else if(symbol.equals("PI")) {
            num1 = Math.PI;
            dis.setText(String.valueOf(num1));
        } else if(symbol.equals("Neg")) {
            double negN = Double.parseDouble(dis.getText())*-1.0;
            num1 = negN;
            dis.setText(String.valueOf(negN));
        } else if(symbol.equals("Log")) {

        } else if(symbol.equals("Ln")) {

        } else if(symbol.equals("Exp")) {

        } else if(symbol.equals("Fact")) {

        } else if(symbol.equals("Clear")) {
            num = Math.max(onClear, num1);
            System.out.println(num + onClear + num1);
            onClear = Double.parseDouble(dis.getText());
            dis.setText(String.valueOf(0));
            operator = "";
        } else if(symbol.equals("AllClear")) {
            dis.setText(String.valueOf(0));
            preDis.setText(String.valueOf(0));
            operator = "";
            num1 = 0;
            num2 = 0;
        } else if(symbol.equals("Equals")) {
            num2 = Double.parseDouble(dis.getText());
            System.out.println(num);
            switch (operator) {
                case "+" -> dis.setText((num1 + num2) + "");
                //Instead of String.valueOf()
                case "-" -> dis.setText((num1 - num2) + "");
                case "*" -> dis.setText((num1 * num2) + "");
                case "/" -> dis.setText((num1 / num2) + "");
                case "%" -> dis.setText((num1 % num2) + "");
            }
            operator = "";
            preDis.setText(String.valueOf(0));
        } else {
            num1 = Double.parseDouble(dis.getText());
            dis.setText(String.valueOf(0));
            switch (symbol) {
                case "Plus" -> operator = "+";
                case "Minus" -> operator = "-";
                case "Multiply" -> operator = "*";
                case "Divide" -> operator = "/";
                case "Remainder" -> operator = "%";
            }
            preDis.setText(String.valueOf(num1));
        }
    }
}