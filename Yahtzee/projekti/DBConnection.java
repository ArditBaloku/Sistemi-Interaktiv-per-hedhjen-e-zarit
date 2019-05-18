package projekti;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private static Connection dbConnection;
	private final static String host = "remotemysql.com";
	private final static String dbName = "Lvxf0xHZPG";
	private final static String username = "Lvxf0xHZPG";
	private final static String password = "g18E4tQbMh";

	public static Connection getConnection() {
		if (dbConnection == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				dbConnection = DriverManager.getConnection("jdbc:mysql://" + host + "/" + dbName, username, password);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return dbConnection;
	}

}
