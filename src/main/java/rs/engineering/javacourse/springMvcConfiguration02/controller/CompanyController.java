package rs.engineering.javacourse.springMvcConfiguration02.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import rs.engineering.javacourse.springMvcConfiguration02.dto.Company;

@Controller
@RequestMapping(value="/companies")
public class CompanyController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("company/companies");
		modelAndView.addObject("action", "Action: view all companies");
		return modelAndView;
		
	}
	@RequestMapping(value ="/add", method = RequestMethod.GET)
	public String add(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("action", "Action: add new company");
		return "company/add";
	}
	
//	@RequestMapping(value = "/save", method = RequestMethod.POST)
//	public String save(HttpServletRequest request, HttpServletResponse response) {
//		String name = request.getParameter("name");
//		String address = request.getParameter("address");
//		
//		System.out.println(name + "\t" + address);
//		return "company/add";
//	}
	
//	@RequestMapping(value = "/save", method = RequestMethod.POST)
//	public String save(@RequestParam(name = "name") String name,
//			@RequestParam(name = "address") String address) {
//	
//		
//		System.out.println(name + "\t" + address);
//		return "redirect:/companies/add";
//	}
	@ModelAttribute(name = "company")
	public Company company() {
		return new Company("n/a", "n/a");
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute(name = "company") Company company) {
		System.out.println(company);
	
		return "redirect:/companies/addModel";
	}
	
	@RequestMapping(value ="/addModel", method = RequestMethod.GET)
	public String addModel(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("action", "Action: add new company");
		return "company/addModel";
	}
}
