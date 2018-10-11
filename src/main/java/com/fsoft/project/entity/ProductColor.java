/**
 * 
 */
package com.fsoft.project.entity;

/**
 * @author hungcoutinho
 *
 */
public class ProductColor {

	private Product product;
	private Color color;

	public ProductColor() {
		super();
	}

	public ProductColor(Product product, Color color) {
		super();
		this.product = product;
		this.color = color;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
