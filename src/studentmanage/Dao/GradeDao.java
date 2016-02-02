package studentmanage.Dao;
 
import java.sql.ResultSet;

import studentmanage.DButils.ADButil;
import studentmanage.DButils.MySqlDButil;
import studentmanage.models.GradeInfo;

public class GradeDao {
	private ADButil db = new MySqlDButil();	

	/**
	 * ����
	 * @param userClass
	 * @return
	 */
	public boolean addGradeInfo(GradeInfo info) {
		
		//�Ȳ�ѯ�Ƿ��Ѿ���ӹ�
		String sqlCount=String.format("SELECT COUNT(1) COUNT FROM Grade WHERE userid = %s",info.getUserid());
		ResultSet rs = db.query(sqlCount);
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
		if(count>0)
			return false;
		
		//����
		String sql = String.format(
				"INSERT INTO Grade (userid,chinese,english,maths) VALUES (%s,%s,%s,%s)",
				info.getUserid(),info.getChinese(),info.getEnglish(),info.getMaths());				
		return db.execute(sql);
	}
}
