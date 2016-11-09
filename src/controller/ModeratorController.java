package controller;
import controller.PropertyId;
import bean.*;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.AdminUser;
import services.ForumService;
import services.LoginService;
import services.ModeratorUser;
import services.PostService;

/*
 * Normal user functionality
 * 
 * */
@WebServlet("/ModeratorController")
public class ModeratorController extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		HttpSession sess = request.getSession(true);
		Moderator mod = (Moderator)sess.getAttribute("mod");
		ModeratorUser mod_user = new ModeratorUser();
		PostService post_service = new PostService();
		String action = request.getParameter("action");
		System.out.println(action);
		System.out.println("modController");
		if(mod != null){
			if(action == null){
				System.out.println("homePage");
				request.setAttribute("mod", mod);
				RequestDispatcher rd = request.getRequestDispatcher("ModeratorHomePage.jsp");
				//System.out.println(mod.getEmergency_number());
				rd.forward(request, response);
			}else if(action.equals("updateUserDetail")){
				request.setAttribute("mod", mod);
				RequestDispatcher rd = request.getRequestDispatcher("ModeratorUpdate.jsp");
				rd.forward(request, response);				
			}else if(action.equals("logout")){
				sess.removeAttribute("mod");
				response.sendRedirect("home.jsp");
			}else if(action.equals("addForum")){
			//	addForum(mod);
				
			}else if(action.equals("closeForum")){
				//closeForum();
			}	
		else{
			response.sendRedirect("home.jsp");
			}
		}  // END OF if
	 }   // END OF doGET
 	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("page_type");
		HttpSession sess = request.getSession(true);
		Moderator mod = (Moderator)sess.getAttribute("mod");
		ModeratorUser update = new ModeratorUser();
		mod.setFirst_name(request.getParameter("First"));
		mod.setLast_name(request.getParameter("Last"));
		mod.setUser_name(request.getParameter("username"));
		mod.setPrimary_email(request.getParameter("pemail"));
		mod.setSecondary_email(request.getParameter("semail"));
		mod.setPostal_address(request.getParameter("postal"));
		mod.setPassword(request.getParameter("password"));
		mod.setEmergency_number(request.getParameter("number"));
		if(update.updateModeratorUser(mod) == 0){
			sess.setAttribute("msg", "Successfully Updated");
		}
		else{
			sess.setAttribute("msg", "Updation Failed");
		}
		request.setAttribute("mod", mod);
		RequestDispatcher rd = request.getRequestDispatcher("ModeratorHomePage.jsp");
		rd.forward(request, response);
	}
	
	//add or registration of new user
	public static int addNormalUser(User user){
		Scanner kb = new Scanner(System.in);
		//((Moderator) user).setKarma(0);
		//code for inserting normal user
		return (new ModeratorUser()).addModeratorUser(user);
	}
	//shows functionality of moderator user
	public void showUserDetail(User user){
		Scanner kb = new Scanner(System.in);
		while(true){
			System.out.println("*************Welecome to Normal User Page************");
	//		System.out.println("Your rating is "+" "+getRating(user)+" "+"5 stars");
			System.out.println("UserName : "+user.getUser_name());
			System.out.println("Please Select a functionality : ");
			System.out.println("1. Show Complete Detail");
			System.out.println("2. Update Your Detail");
			System.out.println("3. Add Forum");
			System.out.println("4. Close Forum");
			System.out.println("5. Logout");
			System.out.println("6. Quit");
			System.out.println("Enter your choice : ");
			int choice = kb.nextInt();
			switch(choice){
			case 1:
				showUsersPersonalDetail(user);
				break;
			case 2:
				updateUserDetail(((Moderator)user));
				break;
			
			case 5:
				System.out.println("Succesfully Logout");
				return;
			
			case 6:
				Quit(user.getUser_name());
				return;
			
			default:
				System.out.println("Please Choice a valid option");
			}
		}
	}
	
	//complete updation of normal  user
	public void updateUserDetail(Moderator user){
		Scanner kb = new Scanner(System.in);
		ModeratorUser obj = new ModeratorUser();
		while(true){
			System.out.println("*************WELCOME To Update Page of Moderator User**********");
			System.out.println("Enter your choice as per given choice : ");
			System.out.println("1.Primary Email Id");
			System.out.println("2.Secondary Email Id ");
			System.out.println("3.First Name");
			System.out.println("4.Last Name");
			System.out.println("5.About Me");
			System.out.println("6.Photo 1 url");
			System.out.println("7.Photo 2 url");
			System.out.println("8.Photo 3 url");
			System.out.println("9.Postal Address");
			System.out.println("10.Password");
			System.out.println("11.Back to user page");
			int choice = kb.nextInt();
			switch(choice){
			case 1:
				System.out.println("Your current email "+user.getPrimary_email());
				boolean check=false;
				do{
					System.out.println("Enter New primary email : ");
					String pemail = kb.next();
				//check
				check=HomeController.isValidEmailAddress(pemail);
				if(check){
					user.setPrimary_email(pemail);
					if(obj.updateModeratorUser(user) == 1){
					System.out.println("Successfully updated");
				}
				}
				else
				{
					System.out.println("Enter a valid email address");
				}
				}while(check!=true);
				break;
			case 2:
				System.out.println("Your current email "+user.getSecondary_email());
				check=false;
				do{
					System.out.println("Enter New primary email : ");
					String pemail = kb.next();
				//check
				check=HomeController.isValidEmailAddress(pemail);
				if(check){
					user.setPrimary_email(pemail);
					if(obj.updateModeratorUser(user) == 1){
					System.out.println("Successfully updated");
				}
				}
				else
				{
					System.out.println("Enter a valid email address");
				}
				}while(check!=true);
				break;
			case 3:
				System.out.println("Your current first name is "+user.getFirst_name());
				System.out.println("Enter new first name : ");
				String fname = kb.next();
				//check
				user.setFirst_name(fname);
				if(obj.updateModeratorUser(user) == 1){
					System.out.println("Successfully updated");
				}
				break;
			case 4:
				System.out.println("Last Name "+user.getLast_name()+"\nUpdate last name : ");
				String lname = kb.next();
				user.setLast_name(lname);
				if(obj.updateModeratorUser(user)  == 1){
					System.out.println("Successfully updated");
				}
				break;
			case 5:
				System.out.println("About me : "+user.getAbout_me());
				System.out.println("Enter new about me : ");
				kb.nextLine();
				String aboutme = kb.nextLine();
				user.setAbout_me(aboutme);
				if(obj.updateModeratorUser(user)  == 1){
					System.out.println("Successfully updated");
				}
				break;
			case 6:
				System.out.println("url1 : "+user.getImage_url()[0]);
				System.out.println("Enter");
				String url1 = kb.next();
				String url[] = user.getImage_url();
				url[0] = url1;
				user.setImage_url(url);
				if(obj.updateModeratorUser(user)  == 1){
					System.out.println("Successfully updated");
				}
				break;
			case 7:
				System.out.println("url2 : "+user.getImage_url()[0]);
				System.out.println("Enter");
				String url2 = kb.next();
				String url11[] = user.getImage_url();
				url11[1] = url2;
				user.setImage_url(url11);
				if(obj.updateModeratorUser(user)  == 1){
					System.out.println("Successfully updated");
				}
				break;
			case 8:
				System.out.println("url3 : "+user.getImage_url()[0]);
				System.out.println("Enter");
				String url3 = kb.next();
				String url22[] = user.getImage_url();
				url22[0] = url3;
				user.setImage_url(url22);
				if(obj.updateModeratorUser(user) == 1){
					System.out.println("Successfully updated");
				}
				break;
			case 9:
				System.out.println("Postal Add "+user.getPostal_address());
				kb.nextLine();
				System.out.println("Enter");
				String postalAdd = kb.nextLine();
				user.setPostal_address(postalAdd);
				if(obj.updateModeratorUser(user) == 1){
					System.out.println("Successfully updated");
				}
				break;
			case 10:
				/*System.out.println("Password "+user.getPassword());
				System.out.println("Enter ");
				String password = kb.next();
				user.setPassword(password);
				if(obj.updateNormalUser(user) == 1){
					System.out.println("Successfully updated");
				}
				break; */
				System.out.println("Your current Password "+user.getPassword());
				check=false;
				do{
					System.out.println("Enter New Password : ");
					String pemail = kb.next();
				//check
				check=HomeController.checkPasswordValidity(pemail);
				if(check){
					user.setPassword(pemail);
					if(obj.updateModeratorUser(user)  == 1){
					System.out.println("Successfully updated");
				}
				}
				else
				{
					System.out.println("Enter a Strong Password");
				}
				}while(check!=true);
				break;
			case 11:
				return;
			}
		}
	}
	
	//show user's personal detail
	public void showUsersPersonalDetail(User user){
		System.out.println("********User's Personal Details******************");
		System.out.println("User name : "+user.getUser_name());
		System.out.println("First Name : "+user.getFirst_name());
		System.out.println("Last Name : "+user.getLast_name());
		//System.out.println("Karma : "+((Moderator)user).getKarma());
		System.out.println("Press any key for go back");
		(new Scanner(System.in)).next();
	}
	//disable
	public void Quit(String user_name){
		LoginService obj = new LoginService();
		if(obj.quitUser(user_name) == 1){
			System.out.println("Successfully Quit");
			return;
		}
	}
	
	//add a moderator or registration
	public static int addModerator(User user){
		Scanner kb = new Scanner(System.in);
		boolean check=false;
		System.out.println("Enter Emergency Number : ");
		do{
			String number=kb.next();
			check=ModeratorController.validateNumber(number);
			if(check && (number.length()>=8 && number.length()<=10)){
				((Moderator)user).setEmergency_number(number);
			}
			else{
				System.out.println("Enter a valid Number");
				check=false;
			}
		}while(check!=true);
	
		System.out.println("Enter No of qualification : ");
		int number = kb.nextInt();
		List<String> qual = new ArrayList<String>();
		for(int i = 0;i < number;i++){
			System.out.println("Enter your qualification no "+(i+1)+" : ");
			qual.add(kb.next());
		}
		((Moderator)user).setQualification(qual);
		//insertion code
		return (new ModeratorUser()).addModeratorUser(user);
	}
	
	//mobile no validation
		 public static boolean validateNumber(String number)
		 {
			
			 for(int i=0;i<number.length();i++)
			 {
				 char c=number.charAt(i);
				 if(!Character.isDigit(c))
				 {
					 return false;
				 }
			 }
			 return true; 
		 }
		 
		 // add forum
		 public void addForum(User user){
			 Scanner sc = new Scanner(System.in);
			 System.out.println("Welcome to A new Forum Page");
			 System.out.println("Enter Forum Topic name");
			 String topic = sc.next();
			 System.out.println("Enter FORUM URL");
			 String url = sc.next();
			 System.out.println("Enter Forum Description");
			 sc.nextLine();
			 String desc = sc.nextLine();
			 Forum forum_obj=new Forum(topic,url,desc,user.getUser_name());
			 ModeratorUser mod_service = new ModeratorUser();
			 if(mod_service.addForum(forum_obj)){
				 System.out.println("Forum Added Successfully");
			 }else{
				 System.out.println("Fail to add Forum");
			 }
		 }
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           