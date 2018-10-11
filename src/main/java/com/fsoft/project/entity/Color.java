/**
 * 
 */
package com.fsoft.project.entity;

/**
 * @author hungcoutinho
 *
 */
public class Color {

	private int id;
	private String color;

	public Color() {
		super();
	}

	public Color(int id, String color) {
		super();
		this.id = id;
		this.color = color;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
