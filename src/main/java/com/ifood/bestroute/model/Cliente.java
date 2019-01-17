package com.ifood.bestroute.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq_cliente", sequenceName = "seq_cliente")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cliente")
	private Long clienteId;

	@Column(name = "nome")
	private String nome;

	@Column(name = "lat")
	private Float lat;

	@Column(name = "lon")
	private Float lon;

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long id) {
		this.clienteId = id;
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
