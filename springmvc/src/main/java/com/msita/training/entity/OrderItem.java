package com.msita.training.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_item", schema="cafedb")
public class OrderItem {
	@EmbeddedId
	private OrderItemKey key;
	
	@Column(name="quantity")
	private int quantity;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idOrder",referencedColumnName="idOrder",nullable = false, insertable = false, updatable = false)
	private Order order;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idp",referencedColumnName="idp",nullable = false, insertable = false, updatable = false)
	private Product product;

	public OrderItemKey getKey() {
		return key;
	}

	public void setKey(OrderItemKey key) {
		this.key = key;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
