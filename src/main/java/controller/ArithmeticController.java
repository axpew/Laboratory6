package controller;

import domain.StackException;
import javafx.event.ActionEvent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class ArithmeticController {


    @javafx.fxml.FXML
    private Text txtMessage;
    @javafx.fxml.FXML
    private Pane mainPain;
    @javafx.fxml.FXML
    private Pane buttonPane1;
    @javafx.fxml.FXML
    private Pane buttonPane;
    @javafx.fxml.FXML
    private RadioButton prefixRB;
    @javafx.fxml.FXML
    private RadioButton infixRB;
    @javafx.fxml.FXML
    private RadioButton postfixRB;
    @javafx.fxml.FXML
    private Pane buttonPane111;
    @javafx.fxml.FXML
    private Pane buttonPane11;
    @javafx.fxml.FXML
    private Text txtMessage1;
    @javafx.fxml.FXML
    private TextField expTF;
    @javafx.fxml.FXML
    private TextArea tf2;
    @javafx.fxml.FXML
    private TextArea tf1;
    @javafx.fxml.FXML
    private Text txtM1;
    @javafx.fxml.FXML
    private Text txtM2;

    //Para controlar la interfaz según el que se presione
    @javafx.fxml.FXML
    public void infixOnAction(ActionEvent actionEvent) {

        this.prefixRB.setSelected(false);
        this.infixRB.setSelected(true);
        this.postfixRB.setSelected(false);

        expTF.setText("");
        tf1.setText("");
        tf2.setText("");

        txtM1.setText("Prefix");
        txtM2.setText("Postfix");

    }

    @javafx.fxml.FXML
    public void postfixOnAction(ActionEvent actionEvent) {

        this.prefixRB.setSelected(false);
        this.infixRB.setSelected(false);
        this.postfixRB.setSelected(true);

        expTF.setText("");
        tf1.setText("");
        tf2.setText("");

        txtM1.setText("Infix");
        txtM2.setText("Prefix");

    }

    @javafx.fxml.FXML
    public void prefixOnAction(ActionEvent actionEvent) {

        this.prefixRB.setSelected(true);
        this.infixRB.setSelected(false);
        this.postfixRB.setSelected(false);

        expTF.setText("");
        tf1.setText("");
        tf2.setText("");

        txtM1.setText("Infix");
        txtM2.setText("Postfix");

    }

    @javafx.fxml.FXML
    public void convertOnAction(ActionEvent actionEvent) throws StackException {

        String expression = expTF.getText();

        if (util.Utility.isBalanced(expression)){

        if(infixRB.isSelected()){

            String infixExp = expTF.getText();
            String prefixExp = util.Utility.infixToPrefixConverter(expression);
            String postfixExp = util.Utility.infixToPostfixConverter(expression);

            if (isNumericExpression(expression)) {
                int result = util.Utility.evaluateInfix(infixExp);
                tf1.setText(prefixExp + " = " + String.valueOf(result));
                tf2.setText(postfixExp + " = " + String.valueOf(result));
            }else{
                tf1.setText(prefixExp);
                tf2.setText(postfixExp);
            }

        }//end if infixRB


            if(prefixRB.isSelected()){

                String infixExp = util.Utility.prefixToInfixConverter(expression);
                String postfixExp = util.Utility.infixToPostfixConverter(infixExp);

                if (isNumericExpression(expression)) {
                    int result = util.Utility.evaluateInfix(infixExp);
                    tf1.setText(infixExp + " = " + String.valueOf(result));
                    tf2.setText(postfixExp + " = " + String.valueOf(result));
                }else{
                    tf1.setText(infixExp);
                    tf2.setText(postfixExp);
                }

            }//end if prefixRB

            if(postfixRB.isSelected()){

                String infixExp = util.Utility.postfixToInfixConverter(expression);
                String prefixExp = util.Utility.infixToPrefixConverter(infixExp);

                if (isNumericExpression(expression)) {
                    int result = util.Utility.evaluateInfix(infixExp);
                    tf1.setText(infixExp + " = " + String.valueOf(result));
                    tf2.setText(prefixExp + " = " + String.valueOf(result));
                }else{
                    tf1.setText(infixExp);
                    tf2.setText(prefixExp);
                }

            }//end if postfixRB


        }else{
            util.FXUtility.showErrorAlert("Error en la expresión", "La expresión no está balanceada, verifique los paréntesis");
        }//End isBalanced Condition



    }//End convertOnAction

    public static boolean isNumericExpression(String exp) {
        for (char c : exp.toCharArray()) {
            if (!Character.isDigit(c) && "+-*/() ".indexOf(c) == -1) {
                return false; // Contiene algo que no es dígito, operador o paréntesis
            }
        }
        return true;
    }

    @javafx.fxml.FXML
    public void cleanOnAction(ActionEvent actionEvent) {

        expTF.setText("");
        tf1.setText("");
        tf2.setText("");

    }
}
