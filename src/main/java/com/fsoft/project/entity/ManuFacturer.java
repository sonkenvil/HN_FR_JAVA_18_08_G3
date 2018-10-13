/**
 * 
 */
package com.fsoft.project.entity;

import java.io.Serializable;

/**
 * @author hungcoutinho
 *
 */
public class ManuFacturer implements Serializable{

	private int id;
	private String name;

	public ManuFacturer() {
		super();
	}

	public ManuFacturer(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
