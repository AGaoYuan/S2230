package cn.news.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BaseDAO {
	/*private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql:///newss2230";
	private static final String user = "root";
	private static final String password = "root";*/

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	// �������ݿ�
	public Connection getConnection() throws Exception {
		/*Class.forName(driver);
		if (con==null||con.isClosed()) {
			con = DriverManager.getConnection(url, user, password);
		}*/
		Context ctx = new InitialContext();
		DataSource data =(DataSource) ctx.lookup("java:comp/env/jdbc/news");
		con = data.getConnection();
		
		return con;
	}

	// ��ɾ��
	public int executeUpdate(String sql, Object... objects) throws Exception {
		getConnection();
		ps = con.prepareStatement(sql);
		for (int i = 0; i < objects.length; i++) {
			ps.setObject(i + 1, objects[i]);
		}
		int count = ps.executeUpdate();
		return count;
	}

	// ��ѯ
	public ResultSet executeQuery(String sql, Object... objects) throws Exception {
		getConnection();
		ps = con.prepareStatement(sql);
		for (int i = 0; i < objects.length; i++) {
			ps.setObject(i + 1, objects[i]);
		}
		rs = ps.executeQuery();
		return rs;
	}

	// ��Դ�ͷ�
	public void CloseAll() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
