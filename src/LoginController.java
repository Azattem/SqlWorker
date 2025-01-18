import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {
    public Button Enter_button;
    public TextField Password_textField;
    public TextField Login_textField;

    public void TryToEnter(ActionEvent actionEvent) {
        System.out.println("Попытка входа");
        if(Login_textField.getText().equals("root")){
        if(Password_textField.getText().equals("qwerty1")){
            try {
                Main.mainstage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Scene/Main.fxml"))));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        }


    }
}
