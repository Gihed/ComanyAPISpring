package com.polytech.web.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.polytech.web.model.Company;
import com.polytech.web.serices.CompanyService;


@Controller
public class CompanyController {
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("name", "Customer");
		return "welcome"; // file jsp
	}
	
	@RequestMapping("/findAll")
	public List<Company> findAll() {
		CompanyService companyService = new CompanyService();
		List<Company> listCompany = companyService.findAll();//
		return listCompany;
	}
	
	@RequestMapping("/all")   //afficher tous les company
	public ModelAndView findAll2() {
		CompanyService companyService = new CompanyService();
		List<Company> listCompany = companyService.findAll();
		
		return new ModelAndView("companyList", "companyList", listCompany);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addCompany() {
		Company company = new Company();
		return new ModelAndView("companyAdd", "company", company);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)  //ajouter une company
	public ModelAndView addCompany(Company company) {
		System.out.println(company);
		CompanyService companyService = new CompanyService();
		companyService.persist(company);
		return new ModelAndView("companyInfo", "company", company);
	}
	
	@RequestMapping(value = "/company", method = RequestMethod.GET)
	public ModelAndView getCompany() {
		Company company = new Company();
		return new ModelAndView("companyInfo", "company", company);
	}
	
	@RequestMapping(value = "/companyById", method = RequestMethod.GET) //chercher par l'id du company
	public ModelAndView getCompany(@RequestParam Integer id) {
		CompanyService companyService = new CompanyService();
		Company company = companyService.findById(id);
		return new ModelAndView("companyInfo", "company", company);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)  //supprimer une company
	public String deleteCompany(@RequestParam Integer id) {
		CompanyService companyService = new CompanyService();
		companyService.delete(id);
		return "redirect:/all";
	}
//	 @RequestMapping(value = "/update", method = RequestMethod.PUT)
//	  public ModelAndView updatCompany(@RequestParam Integer id){
//		 CompanyService companyService = new CompanyService();
//			companyService.update(company);
//			return new ModelAndView(Redirect.from(companyById);
//	     
//	  }
}

