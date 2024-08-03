package com.example.demo.repository.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehiculo")
public class Vehiculo {
	@Id
	@GeneratedValue(generator = "seq_vehiculo", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_vehiculo", sequenceName = "seq_vehiculo", allocationSize = 1)
	@Column(name = "vehiculo_id")
	private Integer id;
	
	@Column(name = "vehiculo_placa")
	private String placa;
	@Column(name = "vehiculo_marca")
	private String marca;
	@Column(name = "vehiculo_modelo")
	private String modelo;
	@Column(name = "vehiculo_color")
	private String color;
	@Column(name = "vehiculo_precio")
	private BigDecimal precio;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
}
