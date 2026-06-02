import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class StudentDAO {

    String url = "jdbc:mysql://localhost:3306/testdb";
    String user = "root";
    String password = "root";

    public void insertStudent(int id, String name) {

        try {
            Connection con =
                DriverManager.getConnection(url, user, password);

            String query =
                "INSERT INTO student(id, name) VALUES(?, ?)";

            PreparedStatement ps =
                con.prepareStatement(query);

            ps.setInt(1, id);
            ps.setString(2, name);

            ps.executeUpdate();

            System.out.println("Student Inserted");

            con.close();

        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public void updateStudent(int id, String name) {

        try {
            Connection con =
                DriverManager.getConnection(url, user, password);

            String query =
                "UPDATE student SET name=? WHERE id=?";

            PreparedStatement ps =
                con.prepareStatement(query);

            ps.setString(1, name);
            ps.setInt(2, id);

            ps.executeUpdate();

            System.out.println("Student Updated");

            con.close();

        } catch(Exception e) {
            System.out.println(e);
        }
    }
}