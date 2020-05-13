package com.polytech.web.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.polytech.web.dao.AddressListDAOInterface;
import com.polytech.web.model.Address;


public class AddressListDAOImpl implements AddressListDAOInterface<Address, String>{
	 private Session currentSession;
	     
	 private Transaction currentTransaction;
	 
	 public Session openCurrentSession() {  
	        currentSession = getSessionFactory().openSession();
	        return currentSession;
	    }
	 
	    public Session openCurrentSessionwithTransaction() {
	        currentSession = getSessionFactory().openSession();
	        currentTransaction = currentSession.beginTransaction();
	        return currentSession;
	    }
	     
	    public void closeCurrentSession() {
	        currentSession.close();
	    }
	     
	    public void closeCurrentSessionwithTransaction() {
	        currentTransaction.commit();
	        currentSession.close();
	    }
	     
	    private static SessionFactory getSessionFactory() {
	        Configuration configuration = new Configuration().configure();
	        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
	                .applySettings(configuration.getProperties());
	        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
	        return sessionFactory;
	    }
	 
	    public Session getCurrentSession() {
	        return currentSession;
	    }
	 
	    public void setCurrentSession(Session currentSession) {
	        this.currentSession = currentSession;
	    }
	 
	    public Transaction getCurrentTransaction() {
	        return currentTransaction;
	    }
	 
	    public void setCurrentTransaction(Transaction currentTransaction) {
	        this.currentTransaction = currentTransaction;
	    }

	@Override
	public void persist(Address entity) {
		getCurrentSession().save(entity);
		
	}

	@Override
	public void update( Address entity) {
		getCurrentSession().update(entity);
		
	}

	@Override
	public Address findById(String id) {
		Address address = (Address) getCurrentSession().get(Address.class, id);
		return address;
	}

	@Override
	public void delete(Address entity) {
		getCurrentSession().delete(entity);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Address> findAll() {
		List<Address> listAddress = (List<Address>) getCurrentSession().createQuery("from Address").list();
		return listAddress;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}



}
