package com.polytech.web.serices;

import java.util.List;

import org.springframework.stereotype.Service;

import com.polytech.web.dao.CompanyListDAOInterface;
import com.polytech.web.dao.impl.CompanyListDAOImpl;
import com.polytech.web.model.Company;

public class CompanyService {
	
	private static CompanyListDAOImpl companyListDAO;
	
	public CompanyService() {
		companyListDAO = new CompanyListDAOImpl();
	}
	
	public void persist(Company entity) {
		companyListDAO.openCurrentSession();
		companyListDAO.persist(entity); // post
		companyListDAO.closeCurrentSession();
	}

	public void update(Company entity) { //put
		companyListDAO.openCurrentSession();
		companyListDAO.update(entity);
		companyListDAO.closeCurrentSession();
	}

	public Company findById(Integer id) {  //get
		companyListDAO.openCurrentSession();
		Company company = companyListDAO.findById(id);
		companyListDAO.closeCurrentSession();
		return company;
	}

	public void delete(Integer id) {  //delete
		companyListDAO.openCurrentSessionwithTransaction();
		Company company = companyListDAO.findById(id);
		companyListDAO.delete(company);
		companyListDAO.closeCurrentSessionwithTransaction();
	}

	public List<Company> findAll() {
		companyListDAO.openCurrentSession();
		List<Company> listCompany = companyListDAO.findAll();
		companyListDAO.closeCurrentSession();
		return listCompany;
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
