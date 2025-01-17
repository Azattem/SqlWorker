import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataBaseController {
    private final Connection connection;
    ArrayList<DataBaseAction> actionList = new ArrayList<>();

    public DataBaseController(String Path, String login, String pass) throws SQLException {
        String url = "jdbc:" + Path + "?useSSL=false&amp&serverTimezone=UTC";
        connection = DriverManager.getConnection(url, login, pass);
    }
    

    //Метод прерывает связь с БД
    public void close(){
        try {
            connection.close();
        } catch (SQLException e) {
        throw new RuntimeException(e);
        }
    }
}
