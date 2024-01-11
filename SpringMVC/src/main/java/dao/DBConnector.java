package dao;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class DBConnector {
	private static Set<DBSession> sessions = new HashSet<>();
	
	
	private static String driverPath = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static String id = "hr";
	private static String pw = "1234";
	
	static {
		try {
			Class.forName(driverPath);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		for(int i = 0 ; i < 10; ++i) {
			sessions.add(new DBSession());
		}
	}
	
	public static DBSession getSession() throws SQLException {
		while(true) {
			for(DBSession session : sessions) {
				if(!session.using) {
					session.using = true; 
					return session;
				}
			}
			
		}
	}

	

	public static String getUrl() {
		return url;
	}

	public static String getId() {
		return id;
	}

	public static String getPw() {
		return pw;
	}
}