package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Vehiculo;

public interface IVehiculoRepository {

	public void insertar(Vehiculo vehiculo);
	public void borrar(String placa);
	public Vehiculo consultar(String placa);
	public List<Vehiculo> buscarTodos();
}
