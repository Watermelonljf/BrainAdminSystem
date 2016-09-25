package com.adminsystem.Pojo;

import java.sql.Date;

public class Goods {
		private int cid;
		private String cname;
		private int cclass;
		private float cprice;
		private float caprice;
		private int ccount;
		private int cscount;
		private String onTime;
		public String getOnTime() {
			return onTime;
		}
		public void setOnTime(String onTime) {
			this.onTime = onTime;
		}
		private String cdep;
		public int getCid() {
			return cid;
		}
		public void setCid(int cid) {
			this.cid = cid;
		}
		public String getCname() {
			return cname;
		}
		public void setCname(String cname) {
			this.cname = cname;
		}
		public int getCclass() {
			return cclass;
		}
		public void setCclass(int cclass) {
			this.cclass = cclass;
		}
		public float getCprice() {
			return cprice;
		}
		public void setCprice(float cprice) {
			this.cprice = cprice;
		}
		public float getCaprice() {
			return caprice;
		}
		public void setCaprice(float caprice) {
			this.caprice = caprice;
		}
		public int getCcount() {
			return ccount;
		}
		public void setCcount(int ccount) {
			this.ccount = ccount;
		}
		public int getCscount() {
			return cscount;
		}
		public void setCscount(int cscount) {
			this.cscount = cscount;
		}
		public String getCdep() {
			return cdep;
		}
		public void setCdep(String cdep) {
			this.cdep = cdep;
		}
}
