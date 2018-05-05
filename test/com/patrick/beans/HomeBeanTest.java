package com.patrick.beans;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HomeBeanTest {
	HomeBean hb = new HomeBean();
	
	@Test
	public void getCurrentDateTest() {
		assertTrue(hb.getCurrentDate() != null);
	}
	
	@Test
	public void getTestValueTest() {
		assertTrue(hb.getTestValue().equals("test value"));
	}
	
}
