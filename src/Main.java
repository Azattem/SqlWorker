import java.sql.*;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static javafx.collections.FXCollections.observableArrayList;


public class Main extends Application {
    public static DataBaseController dataBaseController = new DataBaseController("mysql://localhost:3306/test","root","qwerty1");;
    public static Stage mainstage;
    public TextField TextToAdd;
    public Button Confirm;
    public ListView List;
    public Button SendAll;

    public static void main(String[] args) {
        launch(args);
    }

    public static void setMainstage(Stage mainstage) {
        Main.mainstage = mainstage;
    }

    @Override
    public void start(Stage stage) throws Exception {
        setMainstage(stage);
        Parent root = FXMLLoader.load(getClass().getResource("Scene/login.fxml"));
        stage.setTitle("BaseWorker");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void addToList(ActionEvent actionEvent) {
    dataBaseController.add(new AddDataBaseAction(new DataRow(TextToAdd.getText())));
    refresh();
    }

    private void refresh() {
    ObservableList<String> langs = observableArrayList();
    for (DataBaseAction a : dataBaseController.getActionList()) {
    langs.add(a.toString());
    }
    List.setItems(langs);
    }

    public void sendAll(ActionEvent actionEvent) {
    dataBaseController.connect();
    dataBaseController.executeActions();
    refresh();
    dataBaseController.close();
    }
}