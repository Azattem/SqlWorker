import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataBaseController {
    private Connection connection;
    private final String url;
    private final String login;
    private final String pass;
    ArrayList<DataBaseAction> actionList = new ArrayList<>();

    public DataBaseController(String Path, String login, String pass) {
        this.url="jdbc:" + Path + "?useSSL=false&amp&serverTimezone=UTC";
        this.login=login;
        this.pass=pass;
    }
    public void executeActions(){
    for (DataBaseAction action : actionList) {
    action.execute();
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
