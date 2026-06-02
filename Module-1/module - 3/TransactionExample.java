import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TransactionExample {
    public static void main(String[] args) {

        try {

            Connection con =
                DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb",
                    "root",
                    "root"
                );

            con.setAutoCommit(false);

            String query =
                "INSERT INTO student(id, name) VALUES(?, ?)";

            PreparedStatement ps =
                con.prepareStatement(query);

            ps.setInt(1, 101);
            ps.setString(2, "Ravi");
            ps.executeUpdate();

            ps.setInt(1, 102);
            ps.setString(2, "Priya");
            ps.executeUpdate();

            con.commit();

            System.out.println("Transaction Successful");

            con.close();

        } catch(Exception e) {
            System.out.println("Transaction Failed");
        }
    }
}