package com.polytech.web.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.polytech.web.dao.CompanyListDAOInterface;
import com.polytech.web.model.Company;

public class CompanyListDAOImpl implements CompanyListDAOInterface<Company, Integer>{
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
	public void persist(Company entity) {
		getCurrentSession().save(entity);
		
	}

	@Override
	public void update(Company entity) {
		getCurrentSession().update(entity);
		
	}

	@Override
	public Company findById(Integer id) {
		Company company = (Company) getCurrentSession().get(Company.class, id);
		return company;
	}

	@Override
	public void delete(Company entity) {
		getCurrentSession().delete(entity);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Company> findAll() {
		List<Company> listCompany = (List<Company>) getCurrentSession().createQuery("from Company").list();
		return listCompany;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}


}
