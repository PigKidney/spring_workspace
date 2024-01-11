package dao;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBSession implements Closeable{
	private static String url = DBConnector.getUrl();
	private static String id = DBConnector.getId();
	private static String pw = DBConnector.getPw();
	
	Connection conn;
	boolean using = false;
	
	public DBSession() {
		try {
			conn = DriverManager.getConnection(url, id, pw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public PreparedStatement prepareStatement(String sql) throws SQLException {
		return conn.prepareStatement(sql);
	}
	
	@Override
	public void close() throws IOException {
		using = false;
	}
}