/**
 * 
 */
package com.fsoft.project.entity;

/**
 * @author hungcoutinho
 *
 */
public class LineItem {

	private OrderProduct order;
	private Product product;
	private int numberProduct;

	public LineItem() {
		super();
	}

	public LineItem(OrderProduct order, Product product, int numberProduct) {
		super();
		this.order = order;
		this.product = product;
		this.numberProduct = numberProduct;
	}

	public OrderProduct getOrder() {
		return order;
	}

	public void setOrder(OrderProduct order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getNumberProduct() {
		return numberProduct;
	}

	public void setNumberProduct(int numberProduct) {
		this.numberProduct = numberProduct;
	}

}
