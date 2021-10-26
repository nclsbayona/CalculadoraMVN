/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorgui;

import businessLogic.Calculadora;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author Anabel
 */
public class FXMLDocumentController implements Initializable {

    private float data;
    private int operation = -1;
    private boolean replace = false;

    @FXML
    private Button one;

    @FXML
    private Button eight;

    @FXML
    private Button two;

    @FXML
    private Button three;

    @FXML
    private Button plus;

    @FXML
    private Button five;

    @FXML
    private Button seven;

    @FXML
    private Button four;

    @FXML
    private Button six;

    @FXML
    private Button minus;

    @FXML
    private Button nine;

    @FXML
    private Button mult;

    @FXML
    private Button zero;

    @FXML
    private Button equals;

    @FXML
    private Button clear;

    @FXML
    private Button div;

    @FXML
    private Button back;

    @FXML
    private Button mod;

    @FXML
    private Button signo;

    @FXML
    private Button coma;

    @FXML
    private Button tenPow;

    @FXML
    private Button sqrt;

    @FXML
    private Button nFact;

    @FXML
    private Button log;

    @FXML
    private TextField display;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (replace) {
            display.setText(display.getText().substring(0, display.getText().length() - 1));
            replace = false;
        }
        if (event.getSource() == back) {
            String text = display.getText();
            display.setText(Calculadora.back(text));
            if (display.getText().endsWith(".0"))
                replace = true;
        } else if (event.getSource() == one) {
            display.setText(display.getText() + "1");
        } else if (event.getSource() == two) {
            display.setText(display.getText() + "2");
        } else if (event.getSource() == three) {
            display.setText(display.getText() + "3");
        } else if (event.getSource() == four) {
            display.setText(display.getText() + "4");
        } else if (event.getSource() == five) {
            display.setText(display.getText() + "5");
        } else if (event.getSource() == six) {
            display.setText(display.getText() + "6");
        } else if (event.getSource() == seven) {
            display.setText(display.getText() + "7");
        } else if (event.getSource() == eight) {
            display.setText(display.getText() + "8");
        } else if (event.getSource() == nine) {
            display.setText(display.getText() + "9");
        } else if (event.getSource() == zero) {
            display.setText(display.getText() + "0");
        } else if (event.getSource() == clear) {
            display.setText("");
        } else if (event.getSource() == coma) {
            String value = display.getText();
            if (!value.contains(".")) {
                display.setText(String.valueOf(Calculadora.coma(value)));
                replace = true;
            }
        } else if (event.getSource() == signo) {
            String value = display.getText();
            display.setText(String.valueOf(Calculadora.signo(value)));
        } else if (event.getSource() == plus) {
            replace = false;
            data = Float.parseFloat(display.getText());
            operation = 1; // Addition
            display.setText("");
        } else if (event.getSource() == minus) {
            replace = false;
            data = Float.parseFloat(display.getText());
            operation = 2; // Substraction
            display.setText("");
        } else if (event.getSource() == mult) {
            replace = false;
            data = Float.parseFloat(display.getText());
            operation = 3; // Mul
            display.setText("");
        } else if (event.getSource() == div) {
            replace = false;
            data = Float.parseFloat(display.getText());
            operation = 4; // Division
            display.setText("");
        } else if (event.getSource() == mod) {
            data = Float.parseFloat(display.getText());
            operation = 5; // mod
            display.setText("");
        } else if (event.getSource() == sqrt) { // sqrt
            replace = false;
            data = Float.parseFloat(display.getText());
            display.setText("");
            float ans = Calculadora.sqrt(data);
            display.setText(String.valueOf(ans));
        } else if (event.getSource() == nFact) { // nfact
            data = Integer.parseInt(display.getText());
            display.setText("");
            int ans = Calculadora.nFact((int)data);
            display.setText(String.valueOf(ans));
            replace = false;
        } else if (event.getSource() == signo) { // signo
            String c = display.getText();
            float ans = Calculadora.signo(c);
            display.setText(String.valueOf(ans));
        } else if (event.getSource() == log) { // log
            data = Float.parseFloat(display.getText());
            display.setText("");
            float ans = Calculadora.log(data);
            display.setText(String.valueOf(ans));
        } else if (event.getSource() == tenPow) { // tenPow
            data = Float.parseFloat(display.getText());
            display.setText("");
            float ans = Calculadora.tenPow(data);
            display.setText(String.valueOf(ans));
            replace = false;
        } else if (event.getSource() == equals) {
            float secondOperand = Float.parseFloat(display.getText());
            switch (operation) {
            case 1: // Addition
                float ans = Calculadora.add(data, secondOperand);
                display.setText(String.valueOf(ans));
                break;
            case 2: // Subtraction
                ans = Calculadora.substract(data, secondOperand);
                display.setText(String.valueOf(ans));
                break;
            case 3: // Mul
                ans = Calculadora.multiply(data, secondOperand);
                display.setText(String.valueOf(ans));
                break;
            case 4: // Div
                ans = 0f;
                ans = Calculadora.div(data, secondOperand);
                display.setText(String.valueOf(ans));
                break;
            case 5: // Mod
                ans = 0f;
                ans = Calculadora.mod(data, secondOperand);
                display.setText(String.valueOf(ans));
                break;

            }
        }
    }

    @FXML
    public void initialize(URL arg0, ResourceBundle arg1) {
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert clear != null : "fx:id=\"clear\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert coma != null : "fx:id=\"coma\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert display != null : "fx:id=\"display\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert div != null : "fx:id=\"div\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert eight != null : "fx:id=\"eight\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert equals != null : "fx:id=\"equals\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert five != null : "fx:id=\"five\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert four != null : "fx:id=\"four\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert log != null : "fx:id=\"log\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert minus != null : "fx:id=\"minus\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert mod != null : "fx:id=\"mod\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert mult != null : "fx:id=\"mult\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert nFact != null : "fx:id=\"nFact\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert nine != null : "fx:id=\"nine\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert one != null : "fx:id=\"one\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert plus != null : "fx:id=\"plus\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert seven != null : "fx:id=\"seven\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert signo != null : "fx:id=\"signo\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert six != null : "fx:id=\"six\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert sqrt != null : "fx:id=\"sqrt\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert tenPow != null : "fx:id=\"tenPow\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert three != null : "fx:id=\"three\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert two != null : "fx:id=\"two\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert zero != null : "fx:id=\"zero\" was not injected: check your FXML file 'FXMLDocument.fxml'.";

    }
}
