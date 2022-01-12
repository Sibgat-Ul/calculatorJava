package calculatorApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CalculatorController {
    @FXML private Label dis, preDis;
    @FXML private ImageView btnMinimize, btnClose;
    @FXML private Pane titlePane;

    private double x, y, num1, num2, ans;
    private String operator = "";

    public void init(Stage stage) {
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

    private double factorial(double x) {
        double fact = 1;

        for(int i=2; i <= x; i++) {
            fact *= i;
        }

        return fact;
    }

    @FXML
    void clearBtn() {
        String val = dis.getText();
        String cRes = val.substring(0, val.length()-1);
        dis.setText(cRes);
    }

    @FXML
    void onNumberClick(MouseEvent e) {
        String val = dis.getText();
        String num = ((Pane)e.getSource())
                .getId()
                .replace("btn", "");

        String d = num.equals("Dot") ? "." : num.equals("PI") ? String.valueOf(Math.PI) : num;
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
            case "Sq" -> {
                double sq = Double.parseDouble(dis.getText());
                num1 = sq * sq;
                dis.setText(String.valueOf(num1));
            }
            case "Cb" -> {
                double cb = Double.parseDouble(dis.getText());
                num1 = cb * cb;
                dis.setText(String.valueOf(num1*cb));
            }
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
            case "Prcntg" -> {
                double prctng = Double.parseDouble(dis.getText());
                num1 = prctng/100.0;
                dis.setText(String.valueOf(num1));
            }
            case "1byX" -> {
                double byX = Double.parseDouble(dis.getText());
                num1 = 1.0/byX;
                dis.setText(String.valueOf(num1));
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
            case "E" -> {
                double expNum = Math.exp(1);
                num1 = expNum;
                dis.setText(String.valueOf(num1));
            }
            case "Ex" -> {
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
            case "Sin"-> {
                num1 = Math.sin(Double.parseDouble(dis.getText()));
                dis.setText(String.valueOf(num1));
            }
            case "Cos"-> {
                num1 = Math.cos(Double.parseDouble(dis.getText()));
                dis.setText(String.valueOf(num1));
            }
            case "Tan"-> {
                num1 = Math.tan(Double.parseDouble(dis.getText()));
                dis.setText(String.valueOf(num1));
            }
            case "ArcSin"-> {
                double x = Double.parseDouble(dis.getText());
                num1 = Math.asin(x);
                dis.setText(String.valueOf(num1));
            }
            case "ArcCos"-> {
                double x = Double.parseDouble(dis.getText());
                num1 = Math.acos(x);
                dis.setText(String.valueOf(num1));
            }
            case "ArcTan"-> {
                double x = Double.parseDouble(dis.getText());
                num1 = Math.atan(x);
                dis.setText(String.valueOf(num1));
            }
            case "Abs"-> {
                num1 = Math.abs(Double.parseDouble(dis.getText()));
                dis.setText(String.valueOf(num1));
            }
            case "Cosh"-> {
                num1 = Math.cosh(Double.parseDouble(dis.getText()));
                dis.setText(String.valueOf(num1));
            }
            case "Sinh"-> {
                num1 = Math.sinh(Double.parseDouble(dis.getText()));
                dis.setText(String.valueOf(num1));
            }
            case "Tanh"-> {
                num1 = Math.tanh(Double.parseDouble(dis.getText()));
                dis.setText(String.valueOf(num1));
            }
            case "Rand"-> {
                dis.setText(String.valueOf(Math.random()*100 + 1));
            }
            case "Bin"-> {
                double x = Double.parseDouble(dis.getText());
                int x1 = (int)x;
                num1 = Double.parseDouble(Long.toBinaryString(Long.parseLong(String.valueOf(x1))));
                dis.setText(String.valueOf(num1));
            }
            case "Hex"-> {
                double x = Double.parseDouble(dis.getText());
                int x1 = (int)x;
                dis.setText(Long.toHexString(Long.parseLong(String.valueOf(x1))));
            }
            case "Oct"-> {
                double x = Double.parseDouble(dis.getText());
                int x1 = (int)x;
                num1 = Double.parseDouble(Long.toOctalString(Long.parseLong(String.valueOf(x1))));
                dis.setText(String.valueOf(num1));
            }
            case "Rad"-> {
                double x = Double.parseDouble(dis.getText());
                num1 = Math.toRadians(x);
                dis.setText(String.valueOf(num1));
            }
            case "Deg"-> {
                double x = Double.parseDouble(dis.getText());
                num1 = Math.toDegrees(x);
                dis.setText(String.valueOf(num1));
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
                    case "mod" -> {
                        ans = num1 % num2;
                        dis.setText(ans + "");
                    }
                    case "^" -> {
                        ans = Math.pow(num1, num2);
                        dis.setText(String.valueOf(ans));
                    }
                    case "P" -> {
                        ans = factorial(num1) / factorial((num1-num2));;
                        dis.setText(String.valueOf(ans));
                    }
                    case "C" -> {
                        double n = factorial(num2);
                        double n2 = factorial((num1-num2));
                        ans = factorial(num1)/(n*n2);
                        dis.setText(String.valueOf(ans));
                    }
                    case "E" -> {
                        ans = num1 * Math.pow(10,num2);
                        dis.setText(String.valueOf(ans));
                    }
                    case "," -> {
                        ans = Math.hypot(num1, num2);
                        dis.setText(String.valueOf(ans));
                    }
                    case "Root" -> {
                        ans = Math.round(Math.pow(num1, 1.0 / num2));
                        dis.setText(String.valueOf(ans));
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
                    case "Remainder" -> operator = "mod";
                    case "Pwr" -> operator = "^";
                    case "nPr" -> operator = "P";
                    case "nCr" -> operator = "C";
                    case "Exp" -> operator = "E";
                    case "Hyp" -> operator = ",";
                    case "NthRoot" -> operator = "Root";
                }
                preDis.setText((num1) + operator);
            }
        }
    }
}