import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&amp&serverTimezone=UTC";
        String user = "root";
        String password = "qwerty1";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Подключение к базе данных успешно установлено!");
            System.out.println( connection.getSchema());
            connection.close();
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных:");
            e.printStackTrace();
        }
    }
}