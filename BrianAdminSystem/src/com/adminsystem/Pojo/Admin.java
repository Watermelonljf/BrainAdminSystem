package com.adminsystem.Pojo;

import java.util.Date;


public class Admin {
		private String  name;
		private String password;
		private Date creatTime;
		private Date finallyLoginTime;
		public Admin(String name, String password,
				Date creatTime, Date finallyLoginTime) {
			super();
			this.name = name;
			this.password = password;
		
			this.creatTime = creatTime;
			this.finallyLoginTime = finallyLoginTime;
		}
		public Admin() {
			super();
		}
	
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
	
		public Date getCreatTime() {
			return creatTime;
		}
		public void setCreatTime(Date creatTime) {
			this.creatTime = creatTime;
		}
		public Date getFinallyLoginTime() {
			return finallyLoginTime;
		}
		public void setFinallyLoginTime(Date finallyLoginTime) {
			this.finallyLoginTime = finallyLoginTime;
		}
		@Override
		public String toString() {
			return "Admin [ name=" + name + ", password="
					+ password + ", creatTime=" + creatTime
					+ ", finallyLoginTime=" + finallyLoginTime + "]";
		}
		
		
}
