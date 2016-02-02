package studentmanage.Dao;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;

import studentmanage.DButils.ADButil;
import studentmanage.DButils.MySqlDButil;
import studentmanage.models.UserClassInfo;
import studentmanage.servlet.UserClassEditServlet;

/**
 * �༶dao
 */
public class UserClassDao {
	private ADButil db = new MySqlDButil();
	private Logger logger = Logger.getLogger(UserClassEditServlet.class.getClass());

	/**
	 * ����
	 * 
	 * @param userClass
	 * @return
	 */
	public boolean addUserClassInfo(UserClassInfo userClass) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// �������ڸ�ʽ
		String sql = String.format("insert into userclass (Name,Teacher,Phone,CreateDate)values('%s','%s','%s','%s')",
				userClass.getName(), userClass.getTeacher(), userClass.getPhone(), df.format(new Date()));
		return db.execute(sql);
	}

	/**
	 * ����
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
	 * �޸�
	 * 
	 * @param userClass
	 * @return
	 */
	public boolean updateUserClassInfo(UserClassInfo userClass) {
		String sql = String.format("update userClass set Name='%s',Teacher='%s',Phone='%s' where Id=%s",
				userClass.getName(), userClass.getTeacher(), userClass.getPhone(), userClass.getId());

		return db.execute(sql);
	}

	/**
	 * ɾ��
	 * 
	 * @param ���I
	 * @return
	 */
	public boolean deleteUserClassInfo(int id) {
		try {
			String sql = String.format("DELETE from userClass where Id=%s", id);
			return db.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * ��������
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
					info.setCreatetime(rs.getDate("CreateDate"));
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
	 * ��������
	 * 
	 * @return
	 */
	public ArrayList<UserClassInfo> getUserClassList(int pageIndex, int pageSize) {
		String sql = String.format(
				sql = "select * from USERCLASS where Id limit " + ((pageIndex - 1) * pageSize) + "," + pageSize);
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
					info.setCreatetime(rs.getDate("CreateDate"));
					lst.add(info);
				}
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("���鳤��Ϊ��" + lst.size());
		return lst;
	}

	/**
	 * ��ȡ������
	 */	 
	public int getUserClassListCount() {
		String sql = String.format(sql = "SELECT count(1)as Count FROM USERCLASS");
		ResultSet rs = db.query(sql);
		int count = 0;
		try {
			if (rs != null) {
				while (rs.next()) {
					count = rs.getInt("Count");
					break;
				}
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}

	/**
	 * ���ص���
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
