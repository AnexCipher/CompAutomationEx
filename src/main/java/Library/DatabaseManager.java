package Library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {

	private static final String HOST = "localhost";
	private static final String PORT = "3306";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "123789456";
	private static final String JDBC_URL = "jdbc:mysql://" + HOST + ":" + PORT + "/";

	private static Connection connection;

	static {
		try {
			connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ResultSet executeQuery(String databaseName, String command) throws SQLException {
		Statement statement = connection.createStatement();
		statement.executeUpdate("USE " + databaseName + ";");
		ResultSet result = statement.executeQuery(command);
		return result;
	}

}
