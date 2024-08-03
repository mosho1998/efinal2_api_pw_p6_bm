package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Vehiculo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class VehiculoRepoImpl implements IVehiculoRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.entityManager.persist(vehiculo);
	}

	@Override
	public void borrar(String placa) {
		// TODO Auto-generated method stub
		this.entityManager.remove(placa);
	}

	@Override
	public Vehiculo consultar(String placa) {
		TypedQuery<Vehiculo> query = this.entityManager.createQuery("SELECT v FROM Vehiculo v WHERE v.placa=:datoCodigo", Vehiculo.class);
		query.setParameter("datoCodigo", placa);
		return query.getSingleResult();
	}

	@Override
	public List<Vehiculo> buscarTodos() {
		TypedQuery<Vehiculo> query = this.entityManager.createQuery("SELECT v FROM Vehiculo v", Vehiculo.class);
		
		return query.getResultList();
	}

}
