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
	private Member member;
	private Date createDate;
	private Date updateTime;

	public OrderProduct(int id, double totalPrice, Member member, Date createDate, Date updateTime) {
		super();
		this.id = id;
		this.totalPrice = totalPrice;
		this.member = member;
		this.createDate = createDate;
		this.updateTime = updateTime;
	}

	public OrderProduct() {
		super();
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

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
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
