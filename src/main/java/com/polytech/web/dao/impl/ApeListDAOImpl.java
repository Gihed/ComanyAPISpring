package com.polytech.web.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.polytech.web.dao.ApeListDAOInterface;
import com.polytech.web.model.Ape;

public class ApeListDAOImpl implements ApeListDAOInterface<Ape, Integer> {
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
	public void persist(Ape entity) {
		getCurrentSession().save(entity);

	}

	@Override
	public void update(Ape entity) {
		getCurrentSession().update(entity);

	}

	@Override
	public Ape findById(Integer id) {
		Ape ape = (Ape) getCurrentSession().get(Ape.class, id);
		return ape;
	}

	@Override
	public void delete(Ape entity) {
		getCurrentSession().delete(entity);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ape> findAll() {
		List<Ape> listApe = (List<Ape>) getCurrentSession().createQuery("from Ape").list();
		return listApe;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}
}