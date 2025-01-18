import java.sql.*;

public class Main {
    public static void main(String[] args) {
        DataBaseController s = new DataBaseController("mysql://localhost:3306/test","root","qwerty1");
        s.connect();
        System.out.println(s.getTableData());
        s.executeActions();
        s.close();
    }
}