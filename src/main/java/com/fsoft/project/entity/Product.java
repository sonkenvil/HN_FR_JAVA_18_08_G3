/**
 * 
 */
package com.fsoft.project.entity;

import java.sql.Date;

/**
 * @author hungcoutinho
 *
 */
public class Product {

	private int id;
	private String productName;
	private String imagePath;
	private ManuFacturer manuFacturer;
	private Category category;
	private Date createDate;
	private String color;
	private float price;
	public Product() {
		super();
	}

	

	public Product(int id, String productName, String imagePath, ManuFacturer manuFacturer, Category category,
			Date createDate) {
		super();
		this.id = id;
		this.productName = productName;
		this.imagePath = imagePath;
		this.manuFacturer = manuFacturer;
		this.category = category;
		this.createDate = createDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public ManuFacturer getManuFacturer() {
		return manuFacturer;
	}

	public void setManuFacturer(ManuFacturer manuFacturer) {
		this.manuFacturer = manuFacturer;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}
