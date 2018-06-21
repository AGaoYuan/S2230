package cn.jbit.myschool.impl;

import java.awt.List;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
/**
 * ������
 * @author 21600
 *
 */
public class BaseDao {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	static{//��̬����飬������ص�ʱ��ִ��
		init();
	}
	/**
	 * ��ʼ�����Ӳ������������ļ�����
	 */
	public static void init(){
		Properties params = new Properties();
		String configFile = "database.properties";//�����ļ�·��
		InputStream iS = BaseDao.class.getClassLoader().getResourceAsStream(configFile);
		try {
			params.load(iS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver= params.getProperty("driver");
		url = params.getProperty("url");
		user = params.getProperty("user");
		password = params.getProperty("password");
		
	}
	/**
	 * ��ȡ���ݿ����Ӷ���
	 * @return
	 */
	public Connection getConnection() {
		if (conn==null) {
			//��ȡ���Ӳ������쳣
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url,user,password);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conn;
	}
	/**
	 * �ر����ݿ�����
	 * @param conn ���ݿ����Ӷ���
	 * @param stmt Statement���� (�������ݿ�һЩ����ɾ���ĵĶ���)
	 * @param rs ���صĽ��������
	 */
	public void closeAll(Connection conn,Statement stmt,ResultSet rs){
		//�����������Ϊ�գ���ر�
		try {
			if (rs != null) {
				rs.close();
			}else if (stmt != null) {
				stmt.close();
			}else if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * ����ɾ���ĵĲ���
	 * @param preparedSql Ԥ�����SQL���
	 * @param param �������ַ�������
	 * @return ������Ӱ�������
	 */
	public int exceuteUpdate(String preparedSql,Object [] param){
		int num = 0;
		conn = getConnection();
		try {
			ps = conn.prepareStatement(preparedSql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					//ΪԤ����sql���ò���
					ps.setObject(i+1, param[i]);
				}
			}
			num = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll(conn, ps, null);
		}
		return num;
	}
	
	/**
	 * ���ؽ����
	 * @param sql
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public ResultSet getResultSet(String sql,Object...obj){
		conn = getConnection();
		try {
			ps = conn.prepareStatement(sql);
			if (ps!= null) {
				for (int i = 0; i < obj.length; i++) {
					ps.setObject(i+1, obj[i]);
				}
				rs = ps.executeQuery();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			closeAll(conn, ps, rs);
		}
		
		return rs;
	}
	
	
	
	
	
}
