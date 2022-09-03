package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Persona;
import com.example.demo.repository.modelo.PersonaTo;

@Repository
@Transactional
public class PersonaRepositoryImpl implements IPersonaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Persona persona) {		
		this.entityManager.persist(persona);	
	}

	@Override
	public Persona buscarPersonaId(Integer id) {
		
		return this.entityManager.find(Persona.class, id);
	}

	@Override
	public void actualizar(Persona persona) {
		this.entityManager.merge(persona);
	}

	@Override
	public void eliminar(Integer id) {
		Persona p=this.buscarPersonaId(id);
		this.entityManager.remove(p);
	}
	
	@Override
	public Persona buscarPersonaCedula(String cedula) {
		Query jpqlQuery=this.entityManager
				.createQuery("select p from Persona p Where p.cedula = :datoCedula");
		jpqlQuery.setParameter("datoCedula", cedula);
		
		return (Persona) jpqlQuery.getSingleResult();
	}

	@Override
	public Persona buscarPersonaCedulaTyped(String cedula) {
		TypedQuery<Persona>miTypedQuery= this.entityManager
				.createQuery("select p from Persona p where p.cedula =:datoCedula",Persona.class);
		miTypedQuery.setParameter("datoCedula", cedula);
		return miTypedQuery.getSingleResult();
	}

	@Override
	public Persona buscarPersonaCedulaCriteria(String cedula) {
		CriteriaBuilder myBuilder=this.entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Persona> myQuery=myBuilder.createQuery(Persona.class);
		
		Root<Persona> personaRoot=myQuery.from(Persona.class);
		
		Predicate p1=myBuilder.equal(personaRoot.get("cedula"), cedula);
		
		CriteriaQuery<Persona> myQueryCompleto=myQuery.select(personaRoot).where(p1);
		
		TypedQuery<Persona> myQueryFinal=this.entityManager.createQuery(myQueryCompleto);
		return myQueryFinal.getSingleResult();
	}

	@Override
	public List<PersonaTo> buscarPersonaSencillaApellido(String apellido) {
		TypedQuery<PersonaTo>miTypedQuery= this.entityManager
				.createQuery("select NEW com.example.demo.repository.modelo"
						+ ".PersonaTo(p.nombre,p.apellido) from Persona p "
						+ "where p.apellido =:datoApellido",PersonaTo.class);
		miTypedQuery.setParameter("datoApellido", apellido);
		return miTypedQuery.getResultList();
	}

	@Override
	public List<Persona> buscarTodos() {
		TypedQuery<Persona>miTypedQuery= this.entityManager
				.createQuery("select p from Persona p ",Persona.class);
		return miTypedQuery.getResultList();
	}

}
