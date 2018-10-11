/**
 * 
 */
package com.fsoft.project;

import java.sql.Connection;

import org.junit.Test;

import com.fsoft.project.db.DbHelper;

import junit.framework.TestCase;

/**
 * @author hungcoutinho
 *
 */
public class TestDBHelper extends TestCase {

	@Test
	public void testConnection() {
		Connection conn = DbHelper.getConnection();
		assertTrue(conn != null);
	}

}
