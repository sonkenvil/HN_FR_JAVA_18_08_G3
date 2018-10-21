/**
 * 
 */
package com.fsoft.project;

import java.sql.Connection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fsoft.project.db.DbHelper;

import junit.framework.TestCase;

/**
 * @author hungcoutinho
 *
 */
public class TestDBHelper extends TestCase {
	private Connection conn;
	
	@Before
	public void setUp() throws Exception {
		conn = DbHelper.getConnection();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testConnection() {
		assertTrue(conn != null);
	}

	
}
