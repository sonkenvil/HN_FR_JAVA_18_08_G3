/**
 * 
 */
package com.fsoft.project.db;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author hungcoutinho
 *
 */
public class DbHelperTest {

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetConnection() {
		Connection conn = DbHelper.getConnection();
		assertTrue(conn != null);
	}
}
