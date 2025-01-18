import java.sql.*;
import java.util.ArrayList;

public class DataBaseController {
    private Connection connection = null;
    private final String url;
    private final String login;
    private final String pass;
    ArrayList<DataBaseAction> actionList = new ArrayList<>();

    public DataBaseController(String Path, String login, String pass) {
        this.url="jdbc:" + Path + "?useSSL=false&amp&serverTimezone=UTC";
        this.login=login;
        this.pass=pass;
    }
    public String getTableData(){
        Statement statement = createStatement();
        StringBuilder tableContent = new StringBuilder();
        try {
        if (statement!=null) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM test");
            while (resultSet.next()) {
                tableContent.append(resultSet.getString("id")).append(" ").append(resultSet.getString("info")).append("\n");
            }

        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tableContent.toString();
    }
    //Метод поочердно выполняет все созданые изменения
    public void executeActions() {
        Statement statement = createStatement();
        if (statement!=null) {
            for (DataBaseAction action : actionList) {
                try {
                    statement.executeUpdate(action.execute());
                } catch (SQLException e) {
                System.out.println("Ошибка SQL запроса");
                e.printStackTrace();
                }
            }
            actionList.clear();
        }else {
        System.out.println("Statement пуст");
        }
    }

    private Statement createStatement() {
        try {
            return connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Ошибка доступа к базе данных при создание Statement");
            return null;
        }
    }

    public void clear(){
    actionList = new ArrayList<>();
    }

    public void remove(int index){
    if(index>=0&&index<actionList.size()) {
    actionList.remove(index);
    }
    }
    public void remove(DataBaseAction action){
            actionList.remove(action);
    }

    public void add(DataBaseAction dataBaseAction){
        actionList.add(dataBaseAction);
    }
    //Метод подлючаеться по сылки на заранее заданую базу данных
    public boolean connect(){
        try {
            connection = DriverManager.getConnection(url, login, pass);
            return true;
        } catch (SQLException e) {
            System.out.println("Ошибка при обработке подключения");
            return false;
        }
    }
    //Метод прерывает связь с БД
    public boolean close(){
        try {
            connection.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Ошибка при обработке закрытия");
        return false;
        }
    }
}
