package studentmanage.DButils;

import java.sql.*;

public abstract class ADButil {
	
	public abstract ResultSet query(String sql);
	
	public abstract boolean execute(String sql);
	
}
