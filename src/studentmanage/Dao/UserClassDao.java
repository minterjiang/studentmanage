package studentmanage.Dao;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import studentmanage.DButils.ADButil;
import studentmanage.DButils.MySqlDButil;
import studentmanage.models.UserClassInfo;

/**
 * 班级dao
 */
public class UserClassDao {
	private ADButil db = new MySqlDButil();

	/**
	 * 获取班级
	 */
	public UserClassInfo getUserClassInfo(int id) {
		String sql = String.format(" SELECT * FROM USERCLASS where id=%s", id);
		ResultSet rs = db.query(sql);
		UserClassInfo info = new UserClassInfo();
		try {
			if (rs != null) {
				while (rs.next()) {
					info.setId(rs.getInt("Id"));
					info.setName(rs.getString("Name"));
					info.setCreatetime(rs.getDate("CreaeDate"));
				}
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	/**
	 * 新增
	 * 
	 * @param userClass
	 * @return
	 */
	public boolean addUserClassInfo(UserClassInfo userClass) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String sql = String.format("insert into userclass (Name,Teacher,Phone,CreateDate)values('%s','%s','%s','%s')",
				userClass.getName(), userClass.getTeacher(), userClass.getPhone(), df.format(new Date()));
		return db.execute(sql);
	}

	/**
	 * 新增
	 * 
	 * @param name
	 * @return
	 */
	/**
	 * @param userClassName
	 * @param teacher
	 * @param phone
	 * @return
	 */
	public boolean addUserClassInfo(String userClassName, String teacher, String phone) {

		UserClassInfo info = new UserClassInfo();
		info.setName(userClassName);
		info.setTeacher(teacher);
		info.setPhone(phone);
		return addUserClassInfo(info);
	}

	/**
	 * 修改
	 * 
	 * @param userClass
	 * @return
	 */
	public boolean updateUserClassInfo(UserClassInfo userClass) {
		String sql = String.format("update userClass set Name='$s',Teacher='$s',Phone='$s' where Id=%s",
				userClass.getName(), userClass.getTeacher(), userClass.getPhone(), userClass.getId());
		return db.execute(sql);
	}

	/**
	 * 返回所有
	 * 
	 * @return
	 */
	public ArrayList<UserClassInfo> getUserClassList() {
		String sql = String.format(" SELECT * FROM USERCLASS ");
		ResultSet rs = db.query(sql);
		ArrayList<UserClassInfo> lst = new ArrayList<UserClassInfo>();

		try {
			if (rs != null) {
				while (rs.next()) {
					UserClassInfo info = new UserClassInfo();
					info.setId(rs.getInt("Id"));
					info.setName(rs.getString("Name"));
					info.setTeacher(rs.getString("Teacher"));
					info.setPhone(rs.getString("Phone"));
					info.setCreatetime(rs.getDate("CreaeDate"));
					lst.add(info);
				}
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lst;
	}

	/**
	 * 返回单个
	 * 
	 * @return
	 */
	public UserClassInfo getUserClass(int id) {
		String sql = String.format(" SELECT * FROM USERCLASS WHERE Id = %s ", id);
		ResultSet rs = db.query(sql);

		UserClassInfo info = new UserClassInfo();
		try {
			if (rs != null) {
				while (rs.next()) {
					info.setId(rs.getInt("Id"));
					info.setName(rs.getString("Name"));
					info.setTeacher(rs.getString("Teacher"));
					info.setPhone(rs.getString("Phone"));
					info.setCreatetime(rs.getDate("CreaeDate"));
				}
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}
}
