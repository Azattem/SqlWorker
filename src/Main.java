import java.sql.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    public static void main(String[] args) {
        launch(args);

        DataBaseController s = new DataBaseController("mysql://localhost:3306/test","root","qwerty1");
        s.connect();
        System.out.println(s.getTableData());
        s.executeActions();
        s.close();
    }

    @Override
    public void start(Stage stage) throws Exception {
        //setStage(stage);
        Parent root = FXMLLoader.load(getClass().getResource("Scene/Main.fxml"));
        stage.setTitle("BaseWorker");
        stage.setScene(new Scene(root));
        stage.show();
    }
}