package studentmanage.Test;

import studentmanage.DButils.*;
import java.text.*;
import java.util.Date;

public class Program {

	public static void main(String[] agrs) {
		
		ADButil db = new MySqlDButil();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		 
		String sql = String.format("insert into userclass (Name,CreateDate)values('%s','%s')","王麻子",df.format(new Date()));
		System.out.print(sql);
		boolean b = db.execute(sql);				
		System.out.print(b);
	}
}
