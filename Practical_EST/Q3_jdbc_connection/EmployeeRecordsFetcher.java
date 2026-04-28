import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRecordsFetcher {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/company_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    public static void main(String[] args) {
        String query = "SELECT id, name, email, department, salary FROM employees";

        try (
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery()
        ) {
            System.out.println("Employee Records");
            System.out.println("------------------------------");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String department = resultSet.getString("department");
                double salary = resultSet.getDouble("salary");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
                System.out.println("Department: " + department);
                System.out.println("Salary: " + salary);
                System.out.println("------------------------------");
            }
        } catch (SQLException exception) {
            System.err.println("Database connection or query failed.");
            exception.printStackTrace();
        }
    }
}
