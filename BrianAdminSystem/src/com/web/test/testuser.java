package com.web.test;



import org.junit.Test;

import com.adminsystem.Util.UtilJDBC;

public class testuser {
	
	@Test
	public void testdb(){
		System.out.println(UtilJDBC.getConnection());
	}
}
