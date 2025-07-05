package com.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.user.model.User;
import com.user.service.UserService;
import com.user.service.impl.UserServiceImpl;


@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name = "jdbc/item")
	private DataSource dataSource ;
	
    public UserController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
	       
		if(Objects.isNull(action)){
			action = "welcome";
		}
		switch(action){
		case "welcome":
			welcome(request,response);
			break;
		case "sign-in":
			signIn(request,response);
			break;
		case "log-in":
			logIn(request,response);
			break;
		default :
			action = "welcome";
		}
	}

	private void welcome(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("/welcome.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	private void logIn(HttpServletRequest request, HttpServletResponse response) {
		UserService userService = new UserServiceImpl(dataSource);
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		boolean keepIn = request.getParameter("keepin").equals("on")?true:false;
		User user = new User(userName,password);
		boolean loged = userService.logIn(user);
		if(loged) {
			try {
				HttpSession session = request.getSession();
				session.setAttribute("keepIn", keepIn);
				response.sendRedirect("ItemController");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}else {
			Log log = new Log("404 : account not found :(" , "Sorry sir this data not in our database"
					+ " may the user name pr password are wrong "
					+ "contact our HQ for help or try focusly again ...");
			request.setAttribute("log", log);
			try {
				
				request.getRequestDispatcher("/wrong.jsp").forward(request, response);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}


	private void signIn(HttpServletRequest request, HttpServletResponse response) {
		UserService userService = new UserServiceImpl(dataSource);
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		User user = new User(userName,password);
		boolean signed = userService.signIn(user);
		if(signed) {
			Log log = new Log("permetted"," your account has been written down to our safe database "
					+ "keep them in mind to get into the website any time ,have a nice day :)");
			request.setAttribute("log", log);
			try {
				request.getRequestDispatcher("/wrong.jsp").forward(request, response);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}else {
			Log log = new Log("some thing wierd","the username you tried to sign up with is already used or for some reasons is prohibted ,make sure you sign up or use another name");
			request.setAttribute("log", log);
			try {
				request.getRequestDispatcher("/wrong.jsp").forward(request, response);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
public class Log{
	private String name ;
	private String message;
	public Log(String name , String message) {this.name = name;this.message = message;}
	public String getName(){return name;}
	public String getMessage(){return message;}
	
}
}
