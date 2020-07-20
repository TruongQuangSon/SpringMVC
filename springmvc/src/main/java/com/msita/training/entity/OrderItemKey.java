package com.msita.training.entity;

import java.io.Serializable;

import javax.persistence.Column;

public class OrderItemKey implements Serializable{
	@Column(name="idOrder")
	private int idOrder;
	
	@Column(name="idp")
	private int idProduct;

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	
	
}
