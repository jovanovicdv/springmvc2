package rs.engineering.javacourse.springMvcConfiguration02.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import rs.engineering.javacourse.springMvcConfiguration02.dto.User;

@Controller
@RequestMapping(value = "/user")
public class UserController{

	private List<User> listUser = new ArrayList<User>();
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("/user/users");
		modelAndView.addObject("action", "Action: view all users");
		modelAndView.addObject("list", listUser);
		return modelAndView;
		
	}
	@RequestMapping(value ="/add", method = RequestMethod.GET)
	public String add(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("action", "Action: add new user");
		return "user/add";
	}
	
	@ModelAttribute(name = "user")
	public User user() {
		return new User("", "");
		
	}
	
	
	
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute(name = "user") User user) {
		System.out.println(user);
		
		listUser.add(user);
		
		
	
		return "redirect:/user/add";
	}
	
	

}
