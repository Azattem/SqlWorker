import java.sql.*;

public class Main {
    public static void main(String[] args) {
        DataBaseController s = new DataBaseController("mysql://localhost:3306/test","root","qwerty1");
        s.connect();
        s.add(new AddDataBaseAction(new DataRow("s")));
        s.add(new AddDataBaseAction(new DataRow("s")));
        s.add(new AddDataBaseAction(new DataRow("s")));
        s.executeActions();
        s.remove(3);
        s.close();
    }
}