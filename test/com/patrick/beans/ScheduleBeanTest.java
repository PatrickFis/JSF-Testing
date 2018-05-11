/**
 * 
 */
package com.patrick.beans;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

/**
 * @author Patrick
 *
 */
public class ScheduleBeanTest {

	private ScheduleBean sBean = new ScheduleBean();
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		sBean.init();
	}

	/**
	 * Test method for {@link com.patrick.beans.ScheduleBean#init()}.
	 */
	@Test
	public void testInit() {
		assertNotNull(sBean.getEventModel());
	}

	/**
	 * Test method for {@link com.patrick.beans.ScheduleBean#getEventModel()}.
	 */
	@Test
	public void testGetEventModel() {
		assertNotNull(sBean.getEventModel());
	}

	/**
	 * Test method for {@link com.patrick.beans.ScheduleBean#setEventModel(org.primefaces.model.ScheduleModel)}.
	 */
	@Test
	public void testSetEventModel() {
		ScheduleModel x = new DefaultScheduleModel();
		sBean.setEventModel(x);
		assertTrue(sBean.getEventModel().equals(x));
	}

	/**
	 * Test method for {@link com.patrick.beans.ScheduleBean#getEvent()}.
	 */
	@Test
	public void testGetEvent() {
		assertTrue(sBean.getEvent().equals(new DefaultScheduleEvent()));
	}

	/**
	 * Test method for {@link com.patrick.beans.ScheduleBean#setEvent(org.primefaces.model.ScheduleEvent)}.
	 */
	@Test
	public void testSetEvent() {
		ScheduleEvent x = new DefaultScheduleEvent("Test", new Date(), new Date());
		sBean.setEvent(x);
		assertTrue(sBean.getEvent().equals(x));
	}

}
