package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Vehiculo;

public interface IVehiculoService {

	public void guardar(Vehiculo vehiculo);
	public void eliminar(String placa);
	public Vehiculo buscar(String placa);
	public List<Vehiculo> buscarTodos();
}
