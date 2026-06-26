import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    // Register User
    public void register(User user) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "INSERT INTO users(username,password) VALUES(?,?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, user.username);
            ps.setString(2, user.password);

            int row = ps.executeUpdate();

            if(row > 0) {
                System.out.println("Registration Successful");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Login User
    public boolean login(String username,
                         String password) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "SELECT * FROM users WHERE username=? AND password=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}