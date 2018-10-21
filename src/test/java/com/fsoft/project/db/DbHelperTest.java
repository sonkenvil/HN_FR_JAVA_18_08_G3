/**
 * 
 */
package com.fsoft.project.db;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;

import org.junit.Test;

/**
 * @author hungcoutinho
 *
 */
public class DbHelperTest {

	@Test
	public void testGetConnection() {
		Connection conn = DbHelper.getConnection();
		assertTrue(conn != null);
	}
}
