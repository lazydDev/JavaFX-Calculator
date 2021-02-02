package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private Label result;
    private  long num1 = 0;
    private String operator = "";
    private boolean start = true;

    private Modal modal = new Modal();

    @FXML
    public void processNumbers(ActionEvent event) {
        if (start) {
            result.setText("");
            start = false;
        }

        String value = ((Button)event.getSource()).getText();
        result.setText(result.getText() + value);
    }

    @FXML
    public void processOperators(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();

        if (!value.equals("=")) {
            if (!operator.isEmpty())
                return;

            operator = value;
            num1 = Long.parseLong(result.getText());
            result.setText("");
        } else {
            if (operator.isEmpty())
                return;
            long num2 = Long.parseLong(result.getText());

            float output = modal.calculate(num1, num2, operator);

            result.setText(String.valueOf(output));

            operator = "";
            start = true;
        }
        
    }

}
