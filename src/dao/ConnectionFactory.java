package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private static final String IPBD = "jdbc:mysql://localhost:3306/";
	private static final String NOMEBD = "sistema_egressos";
	private static final String USUARIO = "root";
	private static final String SENHA = "admin";
	
	public static Connection abreConexao() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(IPBD + NOMEBD, USUARIO, SENHA);
		return conn;
	}
	
	private static void fecharTodasConexoes(Connection conn, PreparedStatement psmt, ResultSet rs) throws SQLException{
		if(conn != null){
			conn.close();
		}
		if(psmt != null){
			psmt.close();
		}
		if(rs != null){
			rs.close();
		}
	}
	
	public static void fecha(Connection conn, PreparedStatement psmt, ResultSet rs) throws SQLException{
		fecharTodasConexoes(conn, psmt, rs);
	}
	
	public static void fecha(Connection conn, PreparedStatement psmt) throws SQLException{
		fecharTodasConexoes(conn, psmt, null);
	}
}
