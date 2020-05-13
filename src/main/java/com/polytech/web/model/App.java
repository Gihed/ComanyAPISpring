package com.polytech.web.model;

import java.util.List;

import com.polytech.web.serices.CompanyService;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompanyService companyService = new CompanyService();
		
////		companyService.findById(10);
		System.out.println(companyService.findById(10));
		
		Address adress = new Address("bizerta", "tunis", "comment1", "comment2", "A", "2036" );
		Ape ape = new Ape("activity2", "activityname2", 2000);
		
		companyService.persist(new Company("hello2", 23231, 753159642, adress, ape));
		
		System.out.println("Find all :");
//		
//		List<Company> listCompany = companyService.findAll();
//		
//		for (Company company : listCompany) {
//			System.out.println(company.toString());
//		}

	}

}
