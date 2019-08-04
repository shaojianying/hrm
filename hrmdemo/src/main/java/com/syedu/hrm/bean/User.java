package com.syedu.hrm.bean;

/**
 * User 数据传输类
 * @author qxy
 * @email 1766181826@qq.com
 * @date 2019-07-29 17:13:37
 * @version 1.0
 */
public class User implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String password;
	private int  status;
	private java.util.Date date;

	/** setter and getter method */
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public String getPassword(){
		return this.password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setDate(java.util.Date date){
		this.date = date;
	}
	public java.util.Date getDate(){
		return this.date;
	}

}