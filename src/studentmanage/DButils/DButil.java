package studentmanage.DButils;

import java.sql.*;

public class DButil extends ADButil {

	private String Driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@10.97.190.14:1521:cmfudv1";
	// ���ݿ����ӣ�oracle�������ӵ���oracle���ݿ⣻thin:@MyDbComputerNameOrIP����������ݿ����ڵ�IP��ַ�����Ա���thin:����1521�����������ݿ�Ķ˿ںţ�ORCL����������ݿ�����
	private String UserName = "qidian";
	private String Password = "qidian";// ����
	private Connection _con = null;

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

	public ResultSet query(String sql) {
		ResultSet rs = null;
		try {
			Connection con=getConnection();
			Statement st = con.createStatement();
			rs = st.executeQuery(sql);			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * ִ��sql���	 
	 * @param sql
	 * @return
	 * @exception (�������쳣�Ļ���)
	 * @author Administrator
	 * @Time2012-11-20 15:02:29
	 */
	public boolean execute(String sql) {
		try {
			Connection con=getConnection();
			Statement st = con.createStatement();
			return st.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
