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
	 * 修改信息
	 * 
	 * @param userClass
	 * @return
	 */
	public boolean updateUserClassInfo(StudentInfo info) {
		String sql = String.format("update students set name='%s',userclassid=%s where Id= %s", info.getName(),
				info.getUserclassid(), info.getId());
		return db.execute(sql);
	}

	/**
	 * 获取所有学生的条数
	 * 
	 * @param userClass
	 * @return
	 */
	public int getStudentsListCount() {

		String sql = String.format(sql = "SELECT count(1)as Count FROM students");
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
	 * 修改密码
	 * 
	 * @param
	 * @return
	 */
	public boolean changePwd(String newpwd, int id) {
		String sql = String.format("update students set password ='%s' where Id= %s", newpwd, id);
		return db.execute(sql);
	}

	/**
	 * 删除学生信息
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteStudentInfo(int id) {
		String sql = String.format("DELETE from students where Id=%s", id);
		return db.execute(sql);
	}

	/**
	 * 返回单个学生信息
	 * 
	 * @return
	 */
	public StudentInfo getStudentInfo(int uid) {
		String sql = String.format(" SELECT * FROM students where Id = %s ", uid);
		ResultSet rs = db.query(sql);
		StudentInfo info = new StudentInfo();
		try {
			if (rs != null) {
				while (rs.next()) {

					info.setId(rs.getInt("Id"));
					info.setName(rs.getString("Name"));
					info.setAccount(rs.getString("account"));
					info.setPassword(rs.getString("password"));
					info.setType(rs.getInt("type"));
					info.setUserclassid(rs.getInt("userclassid"));
					info.setCreatetime(rs.getDate("Createtime"));

				}
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	/**
	 * 返回单个学生信息
	 * 
	 * @return
	 */
	public ArrayList<StudentInfo> getStudentInfoByClassId(int uid) {
		String sql = String.format(" SELECT * FROM students where userclassid = %s ", uid);
		logger.info("getStudentInfoByClassId：" + sql);
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

	/**
	 * 根据分页返回
	 * 
	 * @return
	 */
	public ArrayList<StudentInfo> getStudentsList(int pageIndex, int pageSize) {
		String sql = String
				.format("select students.*,userclass.name as 'classname',grade.chinese,grade.english,grade.maths from students left join userclass on(students.userclassid= userclass.Id) left join grade on(students.Id=grade.userid) where students.Id limit "
						+ ((pageIndex - 1) * pageSize) + "," + pageSize);
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
					info.setClassname(rs.getString("classname"));
					info.setChinese(rs.getFloat("chinese"));
					info.setEnglish(rs.getFloat("english"));
					info.setMaths(rs.getFloat("maths"));
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

	/**
	 * @author Administrator
	 */
	public StudentInfo login(String name, String pwd) {
		String sql = String.format(" select students.*,userclass.name as 'classname',grade.chinese,grade.english,grade.maths from students left join userclass on(students.userclassid= userclass.Id) left join grade on(students.Id=grade.userid)  where students.account = '%s' AND students.password = '%s' ", name, pwd);
		ResultSet rs = db.query(sql);
		StudentInfo info = new StudentInfo();
		try {
			if (rs != null) {
				while (rs.next()) {

					info.setId(rs.getInt("Id"));
					info.setName(rs.getString("Name"));
					info.setAccount(rs.getString("account"));
					info.setPassword(rs.getString("password"));
					info.setType(rs.getInt("type"));
					info.setUserclassid(rs.getInt("userclassid"));
					info.setCreatetime(rs.getDate("Createtime"));
					info.setClassname(rs.getString("classname"));
					info.setChinese(rs.getFloat("chinese"));
					info.setEnglish(rs.getFloat("english"));
					info.setMaths(rs.getFloat("maths"));
				}
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}
}
