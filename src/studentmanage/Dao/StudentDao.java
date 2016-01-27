package studentmanage.Dao;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.log4j.Logger;

import studentmanage.DButils.*;
import studentmanage.models.*;

public class StudentDao {
	private ADButil db = new MySqlDButil();
	private Logger logger = Logger.getLogger(StudentDao.class.getClass());

	/**
	 * 新增
	 * 
	 * @param userClass
	 * @return
	 */
	public boolean addStudentInfo(StudentInfo info) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String sql = String.format(
				"INSERT INTO students (account ,password ,name ,userclassid ,createtime ,type ) VALUES ('%s','%s','%s',%s,'%s',%s)",
				info.getAccount(), info.getPassword(), info.getName(), info.getUserclassid(), df.format(new Date()),
				info.getType());
		return db.execute(sql);
	}

	/**
	 * 返回所有
	 * 
	 * @return
	 */
	public ArrayList<StudentInfo> getStudentInfoList() {
		String sql = String.format(" SELECT * FROM students ");
		ResultSet rs = db.query(sql);
		ArrayList<StudentInfo> lst = new ArrayList<StudentInfo>();

		try {
			if (rs != null) {
				while (rs.next()) {
					StudentInfo info = new StudentInfo();
					info.setId(rs.getInt("Id"));
					info.setName(rs.getString("Name"));
					info.setAccount(rs.getString("account"));
					info.setPassword(rs.getString("password"));
					info.setType(rs.getInt("type"));
					info.setUserclassid(rs.getInt("userclassid"));
					info.setCreatetime(rs.getDate("Createtime"));
					lst.add(info);
				}
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("数组长度为：" + lst.size());
		return lst;
	}
 
}
