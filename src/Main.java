import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            new DataBaseController("mysql://localhost:3306/test","root","qwerty1");
            System.out.println("Подключение к базе данных успешно установлено!");

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных:");
            e.printStackTrace();
        }
    }
}