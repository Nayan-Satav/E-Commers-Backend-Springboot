package com.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "orderProducts")
public class OrderProduct 
{
	@EmbeddedId
	@JsonIgnore
	private OrderProductPK pk;

	@Column(nullable = false)
	private Integer quantity = 1;

	public OrderProduct() {
		super();
		// TODO Auto-generated constructor stub
	}	

	public OrderProduct(Order order, Product product, Integer quantity) {
		super();
		pk = new OrderProductPK();
		pk.setOrder(order);
		pk.setProduct(product);
		this.quantity = quantity;
	}

	public OrderProductPK getPk() {
		return pk;
	}

	public void setPk(OrderProductPK pk) {
		this.pk = pk;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
		       return true;
		   }
		   if (obj == null) {
			 return false;
		    }
		   if (getClass() != obj.getClass()) {
			 return false;
		    }
		      OrderProduct other = (OrderProduct) obj;
		   if (pk == null) {
		     if (other.pk != null) {
			return false;
					}
		   } else if (!pk.equals(other.pk)) {
			 return false;
		    }
		   return true;
		 
	}
	
	
	
}
