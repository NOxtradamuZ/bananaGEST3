package com.generation.jwd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.generation.jwd.bean.User;

@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping(method=RequestMethod.GET)
	public String showLogin() {
		
		System.out.println("Get method");
		return "login";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String login (HttpServletRequest request) {
		
		System.out.println("Inicio");
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(email.isEmpty() || password.isEmpty()) {
			
			request.setAttribute("error", "Usuario y/o contraseña están vacíos. Por favor, introduzca correctamente los datos");
			return "login";
		}
		
		//Then, we search in Database if the logger was in there
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
	
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		String hql = "FROM User WHERE email = :email && password = :password";
		Query query = session.createQuery(hql);
		
		query.setParameter("email", email);
		query.setParameter("password", password);
				
//		HttpSession s = request.getSession();
//		s.setAttribute("email", email);
//		s.setAttribute("password", password);
		
		tx.commit();
		session.close();
		
		return "homeuser";
	}
 }

