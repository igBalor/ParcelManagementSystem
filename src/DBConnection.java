import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL =
            "jdbc:sqlserver://localhost;instanceName=BALORSERVER;" +
            "databaseName=ParcelManagementSystem;" +
            "encrypt=true;" +
            "trustServerCertificate=true";

    private static final String USER = "javauser";      // Your SQL Login
    private static final String PASSWORD = "Java@123";  // Your SQL Login Password

    public static Connection getConnection() {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            return DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}