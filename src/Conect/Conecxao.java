package Conect;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Conecxao {
	
	public static Connection conn ; 
	
	public static Connection getConnection() {
		if (conn == null  ) {
			try {
				Properties pro = LoadProperties(); 
				String url = pro.getProperty("dburl"); 
				conn = DriverManager.getConnection(url , pro); 
			}catch (Exception e) {
				throw new EXP(e.getMessage());
				
			}
		}
		return conn ; 
	}
	
	private static Properties LoadProperties () {
		try { FileInputStream fy = new FileInputStream("RecDatesbd");  
			Properties pro = new Properties(); 
			pro.load(fy);
			return pro ; 
		}catch (Exception e) {
			throw new EXP(e.getMessage());
		}
				
				
	}
	
	public static void CloseConnection (  ) {
		if (conn != null  ) {
			try {
				conn.close();
			}catch (SQLException e) {
				throw new EXP(e.getMessage()); 
			}
		}
		
		
	}
	
	public static void CloseResultSet (ResultSet rs ) {
		if (rs != null ) {
			try {
				rs.close();
				
			}catch (SQLException e ) {
				throw new EXP(e.getMessage()); 
			}
		}
	}
	
	public static void CloseStatement (Statement st) {
		if (st != null ) {
			try {
				st.close();
				
			}catch (SQLException e ) {
				throw new EXP(e.getMessage()); 
			}
		}
	}

}
