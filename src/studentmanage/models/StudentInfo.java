package studentmanage.models;

import java.util.*;

public class StudentInfo {

	private int id;	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUserclassid() {
		return userclassid;
	}
	public void setUserclassid(int userclassid) {
		this.userclassid = userclassid;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	private String account;	
	private String password;
	private String name;
	private int userclassid;
	private Date createtime;
	private int type;
	
	
}
