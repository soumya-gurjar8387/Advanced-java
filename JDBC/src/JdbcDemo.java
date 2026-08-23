import java.sql.*;

public class JdbcDemo {

        public static void main(String[] args) throws Exception {

                // Load MySQL JDBC Driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Connect to MySQL database
                Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/college",
                                "root",
                                "YOUR_PASSWORD");

                // Insert record
                PreparedStatement ps = con.prepareStatement(
                                "INSERT INTO student VALUES (?, ?, ?)");

                ps.setInt(1, 101);
                ps.setString(2, "Rahul");
                ps.setString(3, "CSE");

                ps.executeUpdate();

                System.out.println("Record Inserted");

                // Create statement
                Statement st = con.createStatement();

                // Execute SELECT query
                ResultSet rs = st.executeQuery(
                                "SELECT * FROM student");

                // Display records
                while (rs.next()) {
                        System.out.println(
                                        rs.getInt("id") + " " +
                                                        rs.getString("name") + " " +
                                                        rs.getString("branch"));
                }

                // Close connection
                con.close();
        }
}