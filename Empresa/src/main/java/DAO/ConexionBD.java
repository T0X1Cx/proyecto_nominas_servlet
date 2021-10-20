/**
 * 
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author fjdl
 * DriverManager para la conexión a la base de datos
 */

public class ConexionBD {
	

	private static Connection con = null;
    private static String url = "jdbc:mysql://127.0.0.1:3306/nominas";
    private static String username = "root";
    private static String password = "";

	public static Connection getConnection() {
		try {
			if (con == null) {
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
				} catch (ClassNotFoundException e) {
					// TODO: handle exception
				}
				con = DriverManager.getConnection(url, username, password);
				System.out.println("Conexión realizada correctamente");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return con;
	}
	
	public static void close() {
		try {
			if (con != null) con.close();
		} catch (SQLException e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
	}

}
