package DBConnector;

import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;

public class DBConnector {
    /*
        host name: sql213.infinityfree.com
        username: if0_35644285
        password: u4C5EzQYVDGQtu
        port: 3306
        db name: if0_35644285_XXX
     */
    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://sql213.infinityfree.com:3306/if0_35644285_XXX?autoReconnect=true&useSSL=false&connectTimeout=30000";
    private static final String USERNAME = "if0_35644285";
    private static final String PASSWORD = "u4C5EzQYVDGQtu";

    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Establishing a connection
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // Perform database operations (e.g., querying or updating)

            // Example: Query data from a table
            queryData(connection);


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Closing the connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void queryData(Connection connection) throws SQLException {
        String query = "SELECT * FROM DSChamCong";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            // Process the result set
            while (resultSet.next()) {
                // Retrieve data from the result set
                int id = resultSet.getInt("id");
                String columnName = resultSet.getString("column_name");

                // Process the retrieved data as needed
                System.out.println("ID: " + id + ", ColumnName: " + columnName);
            }
        }
    }


}
