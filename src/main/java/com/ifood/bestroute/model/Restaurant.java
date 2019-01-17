package com.ifood.bestroute.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "restaurant")
public class Restaurant implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq_restaurant", sequenceName = "seq_restaurant")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_restaurant")
	private Long restaurantId;

	@Column(name = "nome")
	private String nome;

	@Column(name = "lat")
	private Float lat;

	@Column(name = "lon")
	private Float lon;

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long id) {
		this.restaurantId = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getLat() {
		return lat;
	}

	public void setLat(Float lat) {
		this.lat = lat;
	}

	public Float getLon() {
		return lon;
	}

	public void setLon(Float lon) {
		this.lon = lon;
	}

}
