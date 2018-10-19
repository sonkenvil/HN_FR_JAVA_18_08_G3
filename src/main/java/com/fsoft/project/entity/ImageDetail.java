/**
 * 
 */
package com.fsoft.project.entity;

import java.io.File;

/**
 * @author hungcoutinho
 *
 */
public class ImageDetail {

	private int id;
//	private String imagePath;
	private Product product;
	private int ProductId;
	
	
	private File[]  imageDetailFileName;
    private String[] imageDetail;
    private String[] imageDetailContentType;
    

	

	public File[] getImageDetailFileName() {
		return imageDetailFileName;
	}

	public void setImageDetailFileName(File[] imageDetailFileName) {
		this.imageDetailFileName = imageDetailFileName;
	}

	public String[] getImageDetail() {
		return imageDetail;
	}

	public void setImageDetail(String[] imageDetail) {
		this.imageDetail = imageDetail;
	}

	public String[] getImageDetailContentType() {
		return imageDetailContentType;
	}

	public void setImageDetailContentType(String[] imageDetailContentType) {
		this.imageDetailContentType = imageDetailContentType;
	}

	public ImageDetail() {
		super();
	}

//	public ImageDetail(int id, String imagePath, Product product) {
//		super();
//		this.id = id;
//		this.imagePath = imagePath;
//		this.product = product;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public String getImagePath() {
//		return imagePath;
//	}
//
//	public void setImagePath(String imagePath) {
//		this.imagePath = imagePath;
//	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getProductId() {
		return ProductId;
	}

	public void setProductId(int productId) {
		ProductId = productId;
	}

}
