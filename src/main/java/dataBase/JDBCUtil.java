package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	public static Connection getConnection() throws SQLException {
		Connection con = null;
		String URL = "jdbc:mysql://localhost:3306/sinhvien";
		String user = "root";
		String password = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void closeConnnection(Connection con, Statement stm, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stm != null) {
				stm.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
			try {
				Connection c = JDBCUtil.getConnection();
				if(c==null) {
					System.out.println("0");
				}else {
					System.out.println("1");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
	}
}
