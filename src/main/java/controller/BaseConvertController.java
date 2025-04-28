package controller;

import domain.LinkedStack;
import domain.StackException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class BaseConvertController {
    @FXML
    private Text txtMessage1;
    @FXML
    private Pane buttonPane;
    @FXML
    private RadioButton octalRB;
    @FXML
    private Text txtM2;
    @FXML
    private Text txtMessage;
    @FXML
    private Pane mainPain;
    @FXML
    private Pane buttonPane1;
    @FXML
    private RadioButton binaryRB;
    @FXML
    private Pane buttonPane111;
    @FXML
    private Pane buttonPane11;
    @FXML
    private RadioButton hexadecimalRB;
    @FXML
    private TextArea tfResult;
    @FXML
    private TextField decimalValueTF;

    private int conversionBase = 2; // Default to binary

    @FXML
    public void initialize() {
        // Selección predeterminada: binary
        binaryRB.setSelected(true);
        octalRB.setSelected(false);
        hexadecimalRB.setSelected(false);

        // Solo permitir entrada numérica en el campo de valor decimal
        decimalValueTF.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                decimalValueTF.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }

    @FXML
    public void octalOnAction(ActionEvent actionEvent) {
        binaryRB.setSelected(false);
        octalRB.setSelected(true);
        hexadecimalRB.setSelected(false);
        conversionBase = 8;
        tfResult.clear();
    }

    @FXML
    public void hexadecimalOnAction(ActionEvent actionEvent) {
        binaryRB.setSelected(false);
        octalRB.setSelected(false);
        hexadecimalRB.setSelected(true);
        conversionBase = 16;
        tfResult.clear();
    }

    @FXML
    public void binaryOnAction(ActionEvent actionEvent) {
        binaryRB.setSelected(true);
        octalRB.setSelected(false);
        hexadecimalRB.setSelected(false);
        conversionBase = 2;
        tfResult.clear();
    }

    @FXML
    public void convertOnAction(ActionEvent actionEvent) {
        String decimalStr = decimalValueTF.getText();

        if (decimalStr == null || decimalStr.isEmpty()) {
            util.FXUtility.showErrorAlert("Error de entrada", "Por favor ingrese un valor decimal.");
            return;
        }

        try {
            int decimal = Integer.parseInt(decimalStr);
            String result = "";

            switch (conversionBase) {
                case 2:
                    result = decimalToBinary(decimal);
                    break;
                case 8:
                    result = decimalToOctal(decimal);
                    break;
                case 16:
                    result = decimalToHexadecimal(decimal);
                    break;
            }

            tfResult.setText(result);

        } catch (NumberFormatException e) {
            util.FXUtility.showErrorAlert("Error de entrada", "Valor decimal inválido.");
        } catch (StackException e) {
            util.FXUtility.showErrorAlert("Error de conversión", e.getMessage());
        }
    }

    @FXML
    public void cleanOnAction(ActionEvent actionEvent) {
        decimalValueTF.clear();
        tfResult.clear();
    }

    private String decimalToBinary(int number) throws StackException {
        return decimalToBase(number, 2);
    }

    private String decimalToOctal(int number) throws StackException {
        return decimalToBase(number, 8);
    }

    private String decimalToHexadecimal(int number) throws StackException {
        return decimalToBase(number, 16);
    }

    private String decimalToBase(int number, int base) throws StackException {
        // Caso especial para número 0
        if (number == 0) {
            return "0";
        }

        LinkedStack stack = new LinkedStack();

        // Convertir a la base especificada
        while (number > 0) {
            int remainder = number % base;

            // Para bases mayores a 10, usar letras A-F para dígitos 10-15
            if (remainder < 10) {
                stack.push((char) ('0' + remainder));
            } else {
                stack.push((char) ('A' + (remainder - 10)));
            }

            number = number / base;
        }

        // Construir el resultado extrayendo elementos de la pila
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }
}