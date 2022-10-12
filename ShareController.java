package com.gl.caseStudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gl.caseStudy.bean.CompanyShare;
import com.gl.caseStudy.service.CompanyService;

@RestController
public class ShareController {
	@Autowired
		private CompanyService service;
	
	@GetMapping("/index")
	public ModelAndView showIndexPage() {
	ModelAndView mv=new ModelAndView("index");
	List<CompanyShare> companyList=service.findAll();
	mv.addObject("companyList",companyList);
	return mv;
	}
	@GetMapping("/company-entry")
	public ModelAndView showCompanyEntryPage() {
		CompanyShare company = new CompanyShare();
		ModelAndView mv = new ModelAndView("companyEntryPage");
		mv.addObject("companyRecord",company);
		return mv;
	}
	
	@PostMapping("/company")
	public ModelAndView saveNewCompany(@ModelAttribute("companyRecord") CompanyShare company) {
		Long id = service.generateCompanyId();
		company.setCompanyId(id);
		service.save(company);
		return new ModelAndView("redirect:/index");
	}
	
	
	@GetMapping("/display-course/{id}")
	public ModelAndView showACompanys(@PathVariable long id) {
		CompanyShare company=service.findById(id);
		ModelAndView mv=new ModelAndView("companyReportPage");
		mv.addObject("company",company);
		return mv;
	}
	
	@GetMapping("/delete-company/{id}")
	public ModelAndView deleteACompanys(@PathVariable long id) {
		service.delete(id);
		return new ModelAndView("redirect:/index");
	}

	@GetMapping("/edit-company/{id}")
	public ModelAndView showCompanyEditPage(@PathVariable long id) {
		CompanyShare company=service.findById(id);
		ModelAndView mv=new ModelAndView("companyEditPage");
		mv.addObject("companyRecord",company);
		return mv;
	}
	
	@PostMapping("/edit-company/company-edit")
	public ModelAndView editCompany(@ModelAttribute("companyRecord") CompanyShare company) {
		service.save(company);
		return new ModelAndView("redirect:/index");
	}
	
}