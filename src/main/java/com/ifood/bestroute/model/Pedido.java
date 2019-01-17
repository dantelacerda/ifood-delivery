package com.ifood.bestroute.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "pedido")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq_pedido", sequenceName = "seq_pedido")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pedido")
	private Long pedidoId;

	@Column(name = "restaurantId")
	private Long restaurantId;
	
	@Column(name = "clientId")
	private Long clientId;

	@Column(name = "pickup")
	private Date pickup;

	@Column(name = "delivery")
	private Date delivery;

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long id) {
		this.pedidoId = id;
	}

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public Date getPickup() {
		return pickup;
	}

	public void setPickup(Date pickup) {
		this.pickup = pickup;
	}

	public Date getDelivery() {
		return delivery;
	}

	public void setDelivery(Date delivery) {
		this.delivery = delivery;
	}

}
