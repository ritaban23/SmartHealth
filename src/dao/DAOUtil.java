package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class  DAOUtil {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String connUrl = "jdbc:mysql://localhost:3306/smarthealthdb";
	private static String userName = "root";
	private static String password = "password";
	private static Connection conn = null;
	
	public static Connection getConnection(){
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(connUrl,userName,password);
		}catch(Exception e){
			e.printStackTrace();
		}		
		return conn;
	}
	
	public static void closeConnection(Connection conn) throws Exception{
		conn.close();
	}
	
	public static void closeStatement(Statement st){
		if(st != null){
			try{
				st.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
}
