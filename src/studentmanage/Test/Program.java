package studentmanage.Test;

import studentmanage.DButils.*;
import java.text.*;
import java.util.Date;

public class Program {

	public static void main(String[] agrs) {
		
		ADButil db = new MySqlDButil();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
		 
		String sql = String.format("insert into userclass (Name,CreateDate)values('%s','%s')","������",df.format(new Date()));
		System.out.print(sql);
		boolean b = db.execute(sql);				
		System.out.print(b);
	}
}
