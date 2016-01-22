package studentmanage.DButils;

import java.sql.*;

import org.apache.log4j.Logger;

import studentmanage.servlet.UserClassEditServlet;

public class MySqlDButil extends ADButil {
	private String Driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/studentdb?characterEncoding=UTF-8&characterSetResults=UTF-8&zeroDateTimeBehavior=convertToNull";
	// ���ݿ����ӣ�oracle�������ӵ���oracle���ݿ⣻thin:@MyDbComputerNameOrIP����������ݿ����ڵ�IP��ַ�����Ա���thin:����1521�����������ݿ�Ķ˿ںţ�ORCL����������ݿ�����
	private String UserName = "root";
	private String Password = "";// ����
	private Connection _con = null;
	private Logger logger = Logger.getLogger(UserClassEditServlet.class.getClass());

	public Connection getConnection() {
		if (_con == null) {
			try {
				Class.forName(Driver).newInstance();
				_con = DriverManager.getConnection(url, UserName, Password);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return _con;
	}

	/**
	 * ִ�в�ѯ���
	 * */
	public ResultSet query(String sql) {
		logger.debug(sql);
		ResultSet rs = null;
		try {
			Connection con = getConnection();
			Statement st = con.createStatement();
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * ִ��sql���
	 * 
	 * @param sql
	 * @return
	 * @exception (�������쳣�Ļ���)
	 * @author Administrator
	 * @Time2012-11-20 15:02:29
	 */
	public boolean execute(String sql) {
		logger.debug(sql);
		try {
			Connection con = getConnection();
			Statement st = con.createStatement();
			return st.executeUpdate(sql) > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
