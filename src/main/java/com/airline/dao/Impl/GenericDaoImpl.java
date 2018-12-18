package com.airline.dao.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.airline.dao.GenericDao;
import com.airline.domain.Airport;



/*@SuppressWarnings("unchecked")
@Repository*/
public abstract class GenericDaoImpl<T> implements GenericDao<T> {

	@PersistenceContext
    protected EntityManager entityManager;

    protected Class<T> daoType;

	public void setDaoType(Class<T> type) {
			daoType = type;
	}
   
    @Override
    public void save( T entity ){
    	System.out.println("BBC");
        entityManager.persist( entity );
        System.out.println("CNN");
     }

    public void delete( T entity ){
        entityManager.remove( entity );
     }

	@Override
	public void delete(String id) {
        T entity = findOne( id );
        delete( entity );  
    }

	@Override
	public T findOne( String id ){
	    return (T) entityManager.find( daoType, id );
	 }
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(){
		      return entityManager.createQuery( "from " + daoType.getName() )
		       .getResultList();
		   }
	
	@Override
	public T update( T entity ){
	      return entityManager.merge( entity );
	   }


 }