/**
 * 
 */
package com.fsoft.project.entity;

import java.io.File;
import java.sql.Date;

/**
 * @author hungcoutinho
 *
 */

public class Product {
	private int id;
	private int hidden;
	private int categoryId;
	private int manuFacturerId;
	private String productName;
	private String name;
	private File myFile;
	private String myFileContentType;
	private String imagePath;
	private ManuFacturer manuFacturer;
	private Category category;
	private Date createDate;
	private String color;
	private double price;
	
	
	public Product() {
		super();
	}

	

	public Product(int id, String productName, String imagePath, ManuFacturer manuFacturer, Category category,
			Date createDate, String color, double price) {
		super();
		this.id = id;
		this.productName = productName;
		this.imagePath = imagePath;
		this.manuFacturer = manuFacturer;
		this.category = category;
		this.createDate = createDate;
		this.color = color;
		this.price = price;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getHidden() {
		return hidden;
	}

	public void setHidden(int hidden) {
		this.hidden = hidden;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getManuFacturerId() {
		return manuFacturerId;
	}

	public void setManuFacturerId(int manuFacturerId) {
		this.manuFacturerId = manuFacturerId;
	}

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public String getMyFileContentType() {
		return myFileContentType;
	}

	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
