package studentmanage.DButils;

import java.sql.*;

public class MySqlDButil extends ADButil {
	private String Driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/studentdb?characterEncoding=UTF-8&characterSetResults=UTF-8&zeroDateTimeBehavior=convertToNull";
	// 数据库连接，oracle代表链接的是oracle数据库；thin:@MyDbComputerNameOrIP代表的是数据库所在的IP地址（可以保留thin:）；1521代表链接数据库的端口号；ORCL代表的是数据库名称
	private String UserName = "root";
	private String Password = "";// 密码
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

	/**
	 * 执行查询语句
	 * */
	public ResultSet query(String sql) {
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
	 * 执行sql语句
	 * 
	 * @param sql
	 * @return
	 * @exception (方法有异常的话加)
	 * @author Administrator
	 * @Time2012-11-20 15:02:29
	 */
	public boolean execute(String sql) {
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
