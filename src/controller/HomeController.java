package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.*;

import services.LoginService;
import bean.Admin;
import bean.Moderator;
import bean.NormalUser;
import bean.User;
import dao.DAOUtil;
import dao.LoginDAO;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
handle all initialization steps and login functionality
*/
public class HomeController extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException{
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page_type");
		Scanner kb = new Scanner(System.in);
		HttpSession sess = request.getSession(true);
		sess.setAttribute("msg", "");
		sess.setAttribute("successfulmsg", "");
		System.out.println(page.toString());
		System.out.println("done");
		//LoginDAO ld = new LoginDAO();
		//ld.tmp();
		
		if(page.equals("login")){
			String user_name = request.getParameter("userId");
			String password = request.getParameter("password");
			System.out.println(user_name+" "+password);
			LoginService login_service = new LoginService();
			User user = login_service.getLogin(user_name, password);
			if(user == null){
				sess.setAttribute("msg", "wrong username or password");
				System.out.println("Wrong username or password");
				response.sendRedirect("home.jsp");
				return;
			}
			//else part
		
			if(user.isDisable()){
				sess.setAttribute("msg", "wrong username or password");
				System.out.println("You Previously quit from site.&&&&&&&&&");
				response.sendRedirect("home.jsp");
				return;
			}
			if(user instanceof NormalUser){
				System.out.println("Normal");
				sess.setAttribute("normal_user", user);
				response.sendRedirect("NormalUserController");
				return;
			}else if(user instanceof Admin){
				System.out.println("admin");
				//(new AdminController()).showUserDetail(user);
				sess.setAttribute("admin", user);
				response.sendRedirect("AdminController");
				return;
			}else if(user instanceof Moderator){
				System.out.println("mod");
				sess.setAttribute("mod", user);
				response.sendRedirect("ModeratorController");
				return;
			}
		}else if(page.equals("normal_user_signup")){
			
			NormalUser obj = new NormalUser();
			//System.out.println("Enter the UserName(Unique) : ");
			 boolean check;
			 do{
				 check=false;
				 String user_name = request.getParameter("userId");
				 check=HomeController.checkUserName(user_name, 1);
				 if(check==false)
					 obj.setUser_name(user_name);
				 else{
					 System.out.println("Enter a different User Name");
					 sess.setAttribute("msg", "Enter a different User Name");
					 response.sendRedirect("signup.jsp");
					 return;
				 }
			 }while(check!=false);
			
			 
			 //System.out.println("Enter Password(atleast 8 characters),atleast one char should be Upper case and lower case and atleast one digit should be there: ");
			 check=false;
			 do{
				 String pass = request.getParameter("password");
				 if(check=HomeController.checkPasswordValidity(pass))
					 obj.setPassword(pass);
				 else{
					 System.out.println("Please enter according to the rules");
					 sess.setAttribute("msg", "Please enter password according to the rules");
					 response.sendRedirect("signup.jsp");
					 return;
				 }				 
			 }while(check!=true);
			
			 
			 boolean check_Email=false;
			 boolean check_unique=false;
			 String tmp;
			 System.out.println("Enter Primary Email address : ");
			 do{
				 tmp = request.getParameter("pemail");
				 check_Email=HomeController.isValidEmailAddress(tmp);
				 check_unique=HomeController.isUnique(tmp, 1);
				 if(check_Email && !check_unique){
					 obj.setPrimary_email(tmp);
				 }
				 else
				 {
					 if(!check_Email){
						 System.out.println("Enter a valid email address");
						 sess.setAttribute("msg", "Enter a valid email address");
						 response.sendRedirect("signup.jsp");
						 return;
					 }
					 else{
						 System.out.println("The email id you enter is already present");
						 System.out.println("Enter a different email address");
						 sess.setAttribute("msg", "The email id you enter is already present");
						 response.sendRedirect("signup.jsp");
						 return;
					 }
				 }
			 }while(check_Email!=true ||  check_unique!=false);
			 
			 
			 check_Email=false;
			 //System.out.println("Enter Secondary Email address : ");
			 do{
				 tmp = request.getParameter("semail");
				 check_Email=HomeController.isValidEmailAddress(tmp);
				 if(check_Email){
					 obj.setSecondary_email(tmp);
				 }
				 else
				 {
					 System.out.println("Enter a valid email address");
					 sess.setAttribute("msg", "Enter a valid email address");
					 response.sendRedirect("signup.jsp");
					 return;
				 }
			 }while(check_Email!=true);
		
			 System.out.println("Enter First Name : ");
			 obj.setFirst_name(request.getParameter("fname"));
			 System.out.println("Enter Last Name : ");
			 obj.setLast_name(request.getParameter("lname"));
			 System.out.println("Enter About Me Paragraph : ");
			 //kb.nextLine();
			 obj.setAbout_me(request.getParameter("aboutme"));
			 String url[] = new String[3];
			 System.out.println("Enter First Photo URL : ");
			 url[0] = request.getParameter("furl");
			 System.out.println("Enter Second Photo URL : ");
			 url[1] = request.getParameter("surl");
			 System.out.println("Enter Third Photo URL : ");
			 url[2] = request.getParameter("turl");
			 obj.setImage_url(url);
			 System.out.println("Enter Postal Address : ");
			 obj.setPostal_address(request.getParameter("paddress"));
			 if(NormalUserController.addNormalUser(obj) == 0){
				 sess.setAttribute("successfulmsg", "Successfully signup the normal user now you login");
			 }else{
				 sess.setAttribute("successfulmsg", "Failed to signup the normal user Please try again");
			 }
			 response.sendRedirect("signup.jsp");
			 System.out.println(NormalUserController.addNormalUser(obj));
			 return;
		}else{
			System.out.println("else part");
		}
		while(true){
			System.out.println("************WELCOME TO HOME PAGE************");
			System.out.println("Enter your choice - ");
			System.out.println("1.Register New User");
			System.out.println("2.Login ");
			System.out.println("3.Quit");
			int choice = kb.nextInt();
			if(choice == 3){
				System.out.println("Successfully Quit");
				break;
			}
			switch(choice){
			case 1:
				HomeController.registerNewUser();
				break;
			case 2:
				HomeController.login();
				break;
			}
		}
	}
	//Register a new user
	public static void registerNewUser(){
		Scanner kb = new Scanner(System.in);
		System.out.println("********WELCOME TO REGISTER PAGE**************");
		System.out.println("Enter Your Choice : ");
		System.out.println("1.Register as a Normal User");
		System.out.println("2.Register as a Moderator User");
		System.out.println("3.Register as a Admin");
		System.out.println("4.Back for Home Page");
		int choice = kb.nextInt();
		if(choice == 4){
			return;
		}
		HomeController.registrationPage(choice);
	}
	//make separation on registration
	private static void registrationPage(int choice){
		 Scanner kb = new Scanner(System.in);
		 User obj = null;
		 switch(choice){
		 case 1:
			 obj = new NormalUser();
			 break;
		 case 2:
			 obj = new Moderator();
			 break;
		 case 3:
			 obj = new Admin();
			 break;
	     default:
	    	 System.out.println("Invalid Input");
	    	 return;
		 }
		 System.out.println("Enter the UserName(Unique) : ");
		 boolean check;
		 do{
			 check=false;
			 String user_name=kb.next();
			 check=HomeController.checkUserName(user_name, choice);
			 if(check==false)
				 obj.setUser_name(user_name);
			 else
				 System.out.println("Enter a different User Name");
		 }while(check!=false);
		
		 System.out.println("Enter Password(atleast 8 characters),atleast one char should be Upper case and lower case and atleast one digit should be there: ");
		 check=false;
		 do{
			 String pass=kb.next();
			 if(check=HomeController.checkPasswordValidity(pass))
				 obj.setPassword(pass);
			 else
				 System.out.println("Please enter according to the rules");
			 
		 }while(check!=true);
		
		 
		 boolean check_Email=false;
		 boolean check_unique=false;
		 String tmp;
		 System.out.println("Enter Primary Email address : ");
		 do{
			 tmp = kb.next();
			 check_Email=HomeController.isValidEmailAddress(tmp);
			 check_unique=HomeController.isUnique(tmp, choice);
			 if(check_Email && !check_unique){
				 obj.setPrimary_email(tmp);
			 }
			 else
			 {
				 if(!check_Email)
				 System.out.println("Enter a valid email address");
				 else{
					 System.out.println("The email id you enter is already present");
					 System.out.println("Enter a different email address");
				 }
			 }
		 }while(check_Email!=true ||  check_unique!=false);
		 
		 check_Email=false;
		 System.out.println("Enter Secondary Email address : ");
		 do{
			 tmp = kb.next();
			 check_Email=HomeController.isValidEmailAddress(tmp);
			 if(check_Email){
				 obj.setSecondary_email(tmp);
			 }
			 else
			 {
				 System.out.println("Enter a valid email address");
				 
			 }
		 }while(check_Email!=true);
	
		 System.out.println("Enter First Name : ");
		 obj.setFirst_name(kb.next());
		 System.out.println("Enter Last Name : ");
		 obj.setLast_name(kb.next());
		 System.out.println("Enter About Me Paragraph : ");
		 kb.nextLine();
		 obj.setAbout_me(kb.nextLine());
		 String url[] = new String[3];
		 System.out.println("Enter First Photo URL : ");
		 url[0] = kb.next();
		 System.out.println("Enter Second Photo URL : ");
		 url[1] = kb.next();
		 System.out.println("Enter Third Photo URL : ");
		 url[2] = kb.next();
		 obj.setImage_url(url);
		 System.out.println("Enter Postal Address : ");
		 obj.setPostal_address(kb.next());
		 if(choice == 1){
			 NormalUserController.addNormalUser(obj);
		 }else if(choice == 2){
			 ModeratorController.addModerator(obj);
		 }else{
			 AdminController.addAdmin(obj);
		 }
	}
	
	//login process of a user
	public static void login(){
		Scanner kb = new Scanner(System.in);
		System.out.println("************Welcome to Login Page*********************");
		System.out.println("Enter primary email id : ");
		String user_name = kb.next();
		System.out.println("Enter Password : ");
		String password = kb.next();
		LoginService login_service = new LoginService();
		User user = login_service.getLogin(user_name, password);
		if(user == null){
			
			System.out.println("Wrong username or password");
			return;
		}
		if(user.isDisable()){
			System.out.println("You Previously quit from site.&&&&&&&&&");
			return;
		}
		if(user instanceof NormalUser){
			System.out.println("Normal");
			(new NormalUserController()).showUserDetail(user);
		}else if(user instanceof Admin){
			System.out.println("admin");
			(new AdminController()).showUserDetail(user);
		}else if(user instanceof Moderator){
			System.out.println("mod");
			(new ModeratorController()).showUserDetail(user);
		}
	}
	//email Uniqueness
	public static boolean isUnique(String email,int choice){
		DAOUtil data_object = new DAOUtil();
		 Connection connection = data_object.getConnection();
		 User obj;
		 if(choice==1){
			 obj=new NormalUser();
		 }
		 else
			 if(choice==2)
				 obj=new Moderator();
			 else
				 obj=new Admin();
		 try
		 {
			 String query="select Email1 from user";
			 PreparedStatement ps=connection.prepareStatement(query);
			 ResultSet rs=ps.executeQuery();
			 while(rs.next())
			 {
				if(rs.getString(1).compareToIgnoreCase(email)==0){
					 return true;
				 }
					 
			 }
		 }
		 catch(Exception e){
		 	System.out.println(e.getMessage());
		 }
		 return false;
		
	}
	//Email validation
	 public static boolean isValidEmailAddress(String email) {
         String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
         java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
         java.util.regex.Matcher m = p.matcher(email);
         return m.matches();
	 }
	 //Checking user name uniqness
	 public static boolean checkUserName(String userName,int choice){
		 DAOUtil data_object = new DAOUtil();
		 Connection connection = data_object.getConnection();
		 User obj;
		 if(choice==1){
			 obj=new NormalUser();
		 }
		 else
			 if(choice==2)
				 obj=new Moderator();
			 else
				 obj=new Admin();
		 try
		 {
			 String query="select Username from user";
			 PreparedStatement ps=connection.prepareStatement(query);
			 ResultSet rs=ps.executeQuery();
			 while(rs.next())
			 {
				if(rs.getString(1).compareToIgnoreCase(userName)==0){
					 return true;
				 }
					 
			 }
		 }
		 catch(Exception e){
		 	System.out.println(e.getMessage());
		 }
		 return false;
	 }
	 
	 //password validation
	 public static boolean checkPasswordValidity(String password){
		 int length=password.length();
		 int digit=0;
		 int lowerCase=0;
		 int upperCase=0;
		 int count=0;
		 char ch;
		 if(length>=8)
		 {
			while(count<length)
			{
				ch=password.charAt(count);
				if(Character.isDigit(ch))
				{
					digit=digit+1;
				}
				if(Character.isLowerCase(ch))
					lowerCase++;
				if(Character.isUpperCase(ch))
					upperCase++;
				
				count++;
			}
			if(digit>=1 && lowerCase>=1 && upperCase>=1 )
				return true;
			else
				return false;
		 }
			 return false;
	 }
}
