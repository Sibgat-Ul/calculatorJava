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

    private double x, y, num, num1, num2, onClear, ans;
    private String operator = "";

    private double factorial(double x) {
        double fact = 1;

        for(int i = 2; i <= x; i++) {
            fact *= i;
        }

        return fact;
    }

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
        String valFin = dis.getText()+d;

        if(val.length() == 1 && val.charAt(0) == '0') {
            valFin = valFin.substring(1);
        }

        dis.setText(valFin);
    }

    @FXML
    void onSymbolClick(MouseEvent event) {
        String symbol = ((Pane)event.getSource()).getId().replace("btn","");
        switch (symbol) {
            case "SqRoot" -> {
                double sroot = Math.sqrt(Double.parseDouble(dis.getText()));
                num1 = sroot;
                dis.setText(String.valueOf(sroot));
            }
            case "CbRoot" -> {
                double croot = Math.cbrt(Double.parseDouble(dis.getText()));
                num1 = croot;
                dis.setText(String.valueOf(croot));
            }
            case "PI" -> {
                num1 = Math.PI;
                dis.setText(String.valueOf(num1));
            }
            case "Neg" -> {
                double negN = Double.parseDouble(dis.getText()) * -1.0;
                num1 = negN;
                dis.setText(String.valueOf(negN));
            }
            case "Log" -> {
                //need to work on this
                double a = Double.parseDouble(dis.getText());
                num1 = Math.log10(a);
                dis.setText(String.valueOf(num1));
            }
            case "Ln" -> {
                double a = Double.parseDouble(dis.getText());
                num1 = Math.log(a);
                dis.setText(String.valueOf(num1));
            }
            case "Exp" -> {
                double a = Double
                        .parseDouble(dis
                                .getText());
                double expNum = Math.exp(a);
                num1 = expNum;
                dis.setText(String.valueOf(num1));
            }
            case "Fact" -> {
                double z = factorial(Double.parseDouble(dis.getText()));
                num1 = z;
                dis.setText(String.valueOf(z));
            }
            case "Clear" -> {
                num1 = 0;
                dis.setText(String.valueOf(num1));
                operator = "";
            }
            case "AllClear" -> {
                dis.setText(String.valueOf(0));
                preDis.setText(String.valueOf(0));
                operator = "";
                num1 = 0;
                num2 = 0;
            }
            case "Ans" -> {
                num1 = ans;
                dis.setText(num1 + "");
            }
            case "Equals" -> {
                num2 = Double.parseDouble(dis.getText());
                switch (operator) {
                    case "+" -> {
                        ans = num1 + num2;
                        dis.setText(ans + "");
                        //Instead of String.valueOf()
                    }
                    case "-" -> {
                        ans = num1 - num2;
                        dis.setText(ans + "");
                    }
                    case "*" -> {
                        ans = num1 * num2;
                        dis.setText(ans + "");
                    }
                    case "/" -> {
                        ans = num1 / num2;
                        dis.setText(ans + "");
                    }
                    case "%" -> {
                        ans = num1 % num2;
                        dis.setText(ans + "");
                    }
                }
                operator = "";
                preDis.setText(String.valueOf(0));
            }
            default -> {
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
}