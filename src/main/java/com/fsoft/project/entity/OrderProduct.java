/**
 * 
 */
package com.fsoft.project.entity;

import java.sql.Date;

/**
 * @author hungcoutinho
 *
 */
public class OrderProduct {

	private int id;
	private double totalPrice;
	private int memberId;
	private Date createDate;
	private Date updateTime;

	public OrderProduct() {
		super();
	}

	public OrderProduct(int id, double totalPrice, int memberId, Date createDate, Date updateTime) {
		super();
		this.id = id;
		this.totalPrice = totalPrice;
		this.memberId = memberId;
		this.createDate = createDate;
		this.updateTime = updateTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
