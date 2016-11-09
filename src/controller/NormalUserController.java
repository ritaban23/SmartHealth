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
import services.NormalUserService;
import services.PostService;

/*
 * Normal user functionality
 * 
 * */
@WebServlet("/NormalUserController")
public class NormalUserController extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		HttpSession sess = request.getSession(true);
		NormalUser normal_user = (NormalUser)sess.getAttribute("normal_user");
		NormalUserService n_user = new NormalUserService();
		PostService post_service = new PostService();
		String action = request.getParameter("action");
		System.out.println(action);
		
		if(normal_user != null){
			if(action == null){
				request.setAttribute("normal_user", normal_user);
				RequestDispatcher rd = request.getRequestDispatcher("NormalUserHomePage.jsp");
				rd.forward(request, response);
			}else if(action.equals("updateUserDetail")){
				request.setAttribute("normal_user", normal_user);
				RequestDispatcher rd = request.getRequestDispatcher("NormalUserUpdatePage.jsp");
				rd.forward(request, response);				
			}else if(action.equals("logout")){
				sess.removeAttribute("normal_user");
				response.sendRedirect("home.jsp");
			}else if(action.equals("sendFriendRequest")){
				List<String> all_normal_user = n_user.getAllUserName(normal_user.getUser_name());
				request.setAttribute("all_normal_user", all_normal_user);
				RequestDispatcher rd = request.getRequestDispatcher("NormalUserAllPossibleFriends.jsp");
				rd.forward(request, response);
			}else if(action.equals("addFriend")){
				if(n_user.sendRequest(normal_user.getUser_name(),request.getParameter("user_name"))){
						sess.setAttribute("msg", "Successfully Sent Friend Request");
						response.sendRedirect("NormalUserController");
				}
				//else part
			}else if(action.equals("seeAllFriendRequest")){
				List<String> obj = n_user.findFriendForRequest(normal_user.getUser_name());
				request.setAttribute("all_recieve_request", obj);
				RequestDispatcher rd = request.getRequestDispatcher("NormalUserAllRecieveFriendRequest.jsp");
				rd.forward(request, response);
			}else if(action.equals("acceptFriendRequest")){
//				System.out.println("Accept"+normal_user.getUser_name()+" "+request.getParameter("user_name"));
				if(n_user.acceptRequest(request.getParameter("user_name"),normal_user.getUser_name())){
					sess.setAttribute("msg", "Successfully accepted friend request");
					response.sendRedirect("NormalUserController");
				}				
			}else if(action.equals("seeAllFriends")){
				List<String> obj = n_user.seeAllFriends(normal_user.getUser_name());
				request.setAttribute("all_friends", obj);
				RequestDispatcher rd = request.getRequestDispatcher("NormalUserAllFriend.jsp");
				rd.forward(request, response);
			}else if(action.equals("UnFriend")){
				//Ritaban Check, correct it and do
			}else if(action.equals("seeAllFourm")){
				List<Forum> obj = (new ForumService()).getForumList();
				request.setAttribute("all_forums", obj);
				RequestDispatcher rd = request.getRequestDispatcher("NormalUserAllForum.jsp");
				rd.forward(request, response);
			}else if(action.equals("forumPost")){
				int forumid = Integer.parseInt(request.getParameter("forumid").toString());
				System.out.println("forum");
				List<Post> all_posts = post_service.seeAllPosts(forumid);
				List<Forum> obj = (new ForumService()).getForumList();
				Forum forum = null;
				for(Forum fo:obj){
					if(fo.getForum_id() == forumid){
						forum = fo;
						break;
					}
				}
				request.setAttribute("all_posts", all_posts);
				request.setAttribute("forum", forum);
				RequestDispatcher rd = request.getRequestDispatcher("NormalUserAllPosts.jsp");
				rd.forward(request, response);
			}
		}else{
			response.sendRedirect("home.jsp");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("page_type");
		HttpSession sess = request.getSession(true);
		NormalUser normal_user = (NormalUser)sess.getAttribute("normal_user");
		NormalUserService update = new NormalUserService();
		normal_user.setFirst_name(request.getParameter("First"));
		normal_user.setLast_name(request.getParameter("Last"));
		normal_user.setUser_name(request.getParameter("username"));
		normal_user.setPrimary_email(request.getParameter("pemail"));
		normal_user.setSecondary_email(request.getParameter("semail"));
		normal_user.setPostal_address(request.getParameter("postal"));
		normal_user.setPassword(request.getParameter("password"));
		if(update.updateNormalUser(normal_user) == 0){
			sess.setAttribute("msg", "Successfully Updated");
		}
		else{
			sess.setAttribute("msg", "Updation Failed");
		}
		request.setAttribute("normal_user", normal_user);
		RequestDispatcher rd = request.getRequestDispatcher("NormalUserHomePage.jsp");
		rd.forward(request, response);
	}
	
	//add or registration of new user
	public static int addNormalUser(User user){
		Scanner kb = new Scanner(System.in);
		((NormalUser) user).setKarma(0);
		//code for inserting normal user
		return (new NormalUserService()).addNormalUser(user);
	}
	//shows functionality of normal user
	public void showUserDetail(User user){
		Scanner kb = new Scanner(System.in);
		while(true){
			System.out.println("*************Welecome to Normal User Page************");
			System.out.println("Your rating is "+" "+getRating(user)+" "+"5 stars");
			System.out.println("UserName : "+user.getUser_name());
			System.out.println("Please Select a functionality : ");
			System.out.println("1. Show Complete Detail");
			System.out.println("2. Update Your Detail");
			System.out.println("3. Send Request");
			System.out.println("4. Seen all send Request");
			System.out.println("5. See all friend Request");
			System.out.println("6. Accept Requests");
			System.out.println("7. Unfriend");
			System.out.println("8. See All Friends");
			System.out.println("9. Update Heath data");
			System.out.println("10. See Complete Health Detail");
			System.out.println("11. See Friend's Complete Health Detail");
			System.out.println("12. Quit");
			System.out.println("13. Logout");
			System.out.println("14. Show all Forums");
			System.out.println("15. Post or comment on Any Forum");
			System.out.println("16. Rate any Post");
			System.out.println("17. See All Posts");
			System.out.println("Enter your choice : ");
			int choice = kb.nextInt();
			switch(choice){
			case 1:
				showUsersPersonalDetail(user);
				break;
			case 2:
				updateUserDetail(((NormalUser)user));
				break;
			case 3:
				sendRequest(user);
				break;
			case 4:
				seeSendRequest(user);
				break;
			case 5:
				seeAllRequest(user);
				break;
			case 6:
				acceptRequest(user);
				break;
			case 7:
				unFriend(user);
				break;
			case 8:
				seeAllFriends(user);
				break;
			case 9:
				updateHealthData((NormalUser)user);
				break;
			case 10:
				seeHealthData((NormalUser)user);
				break;
			case 11:
				seeFriendsHealthData((NormalUser)user);
				break;
			case 12:
				Quit(user.getUser_name());
				return;
			case 13:
				System.out.println("Succesfully Logout");
				return;
			case 14:
				showForum(user);
				break;
			case 15:
				postComment(user);
				break;
			//case 16:
				//ratePost(user);
				//break;
			case 17:
				seeAllPosts(user);
				break;
			default:
				System.out.println("Please Choice a valid option");
			}
		}
	}
	public void seeHealthData(NormalUser user){
		//provide username and fetch data from Datum table
		int count=0;
		NormalUserService obj=new NormalUserService();
		List<String> obj1 = obj.seeHealthData(user.getUser_name());
		if(obj1!=null){
			for(String itr:obj1){
				if(count==0)
				{
					System.out.println("BP IS "+" "+itr);
					count++;
				}
				else
					if(count==1){
						System.out.println("Calories burned is"+" "+itr);
						count++;
					}
					else{
						System.out.println("Kilometeres ran"+" "+itr);
						count=0;
					}
			}   // end of the iterator loop
		}
		else
			System.out.println("you dont have any medical condition as of now");
		
	}
	public void seeFriendsHealthData(NormalUser user){
		//we username use NormaluserService class to fetch friends name and ask for username to whom user want to see health data
		Scanner sc=new Scanner(System.in);
		int count=0;
		NormalUserService obj=new NormalUserService();
		List<String> obj1=obj.seeAllFriends(user.getUser_name());
		if(!(obj1.isEmpty())){
			System.out.println("List of All Friends:");
			for(String str:obj1)
					System.out.println(str);
			
		int choice;
		do{
			System.out.println("Do you want to see Health Data of your friends 1--Yes 0--No ??");
			
			choice=sc.nextInt();
			System.out.println("Enter a valid friend's name");
			String username=sc.next();
			if(!(obj1.contains(username))){
				System.out.println("Enter a valid user name");
				continue;
			}
			List<String> obj2=obj.seeHealthData(username);
			if(obj2!=null){
				for(String itr:obj2){
					if(count==0)
					{
						System.out.println("BP IS "+" "+itr);
						count++;
					}
					else
						if(count==1){
							System.out.println("Calories burned is"+" "+itr);
							count++;
						}
						else{
							System.out.println("Kilometeres ran"+" "+itr);
							count=0;
						}
				}   // end of the iterator loop
			}
			else
				System.out.println("your Friend doesnt have any medical condition as of now");
			
			System.out.println("Do u want to continue 1-Yes 0--No");
			choice=sc.nextInt();
			}while(choice==1);
		}
		else
		{
			System.out.println("You Donot have any friends");
		}
	}
	public void updateHealthData(NormalUser user){
		Scanner kb = new Scanner(System.in);
		List<Datum> obj = new ArrayList<Datum>();
		NormalUserService ns = new NormalUserService();
		System.out.println("Enter BP Value : ");
		String value = kb.next();
		obj.add(new Datum(user.getUser_name(),PropertyId.BP_ID,value));
		System.out.println("Enter Calories Burn Value : ");
		value = kb.next();
		obj.add(new Datum(user.getUser_name(),PropertyId.CALBURNED_ID,value));
		System.out.println("Enter Kilometer Run Value : ");
		value = kb.next();
		obj.add(new Datum(user.getUser_name(),PropertyId.KILOMETERSRAN_ID,value));
		if(ns.updateDatum(obj)){
			System.out.println("Datum Updated");
		}
	}
	//complete updation of normal  user
	public void updateUserDetail(NormalUser user){
		Scanner kb = new Scanner(System.in);
		NormalUserService obj = new NormalUserService();
		while(true){
			System.out.println("*************WELCOME To Update Page of Normal User**********");
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
					if(obj.updateNormalUser(user) == 1){
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
					if(obj.updateNormalUser(user) == 1){
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
				if(obj.updateNormalUser(user) == 1){
					System.out.println("Successfully updated");
				}
				break;
			case 4:
				System.out.println("Last Name "+user.getLast_name()+"\nUpdate last name : ");
				String lname = kb.next();
				user.setLast_name(lname);
				if(obj.updateNormalUser(user) == 1){
					System.out.println("Successfully updated");
				}
				break;
			case 5:
				System.out.println("About me : "+user.getAbout_me());
				System.out.println("Enter new about me : ");
				kb.nextLine();
				String aboutme = kb.nextLine();
				user.setAbout_me(aboutme);
				if(obj.updateNormalUser(user) == 1){
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
				if(obj.updateNormalUser(user) == 1){
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
				if(obj.updateNormalUser(user) == 1){
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
				if(obj.updateNormalUser(user) == 1){
					System.out.println("Successfully updated");
				}
				break;
			case 9:
				System.out.println("Postal Add "+user.getPostal_address());
				kb.nextLine();
				System.out.println("Enter");
				String postalAdd = kb.nextLine();
				user.setPostal_address(postalAdd);
				if(obj.updateNormalUser(user) == 1){
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
					if(obj.updateNormalUser(user) == 1){
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
		System.out.println("Karma : "+((NormalUser)user).getKarma());
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
	//send a friend user
	public void sendRequest(User user){
		Scanner kb = new Scanner(System.in);
		NormalUserService n_user = new NormalUserService();
		List<String> obj = n_user.getAllUserName(user.getUser_name());
		System.out.println("Please Select User from given list");
		for(String str:obj){
			System.out.println(str);
		}
		System.out.println("Please Enter a valid user name");
		String r_user = kb.next();
		if(n_user.sendRequest(user.getUser_name(),r_user)){
			System.out.println("Request send successfully");
		}else{
			System.out.println("fail");
		}
	}
	//see all sent request which are not accepted
	public void seeSendRequest(User user){
		NormalUserService n_user = new NormalUserService();
		List<String> obj = n_user.seeSendRequest(user.getUser_name());
		System.out.println("List of send Request : ");
		for(String str:obj){
			System.out.println(str);
		}
	}
	//see all receive request
	public void seeAllRequest(User user){
		NormalUserService n_user = new NormalUserService();
		List<String> obj = n_user.seeAllRequest(user.getUser_name());
		System.out.println("List of Received  Requests : ");
		for(String str:obj){
			System.out.println(str);
		}
	}
	//accept friend request
		public void acceptRequest(User user){
			Scanner sc=new Scanner(System.in);
			NormalUserService n_user = new NormalUserService();
			List<String> obj1=n_user.seeAllRequest(user.getUser_name());
			if(!(obj1.isEmpty())){
				System.out.println("List of Received  Requests : ");
			for(String str:obj1){
				System.out.println(str);
				} 			
			System.out.println("Do you want to confirm any of the friend Request 1--Yes 0--No ??");
			int choice;
			choice=sc.nextInt();
			if(choice==1){
			do{
				System.out.println("Enter a valid friend's name");
				String username=sc.next();
				if(!(obj1.contains(username))){
					System.out.println("Enter a valid user name");
					continue;
				}
					
				if(n_user.acceptRequest(user.getUser_name(),username)){
					System.out.println("You have accepted the friend Request Successfully");
				}
				System.out.println("Do u want to continue 1-Yes 0--No");
				choice=sc.nextInt();
				}while(choice==1);
			}
			else
			{
				System.out.println("You have ignored all the requests");
			}
			}
		else
			System.out.println("There are no Pending Requests");
		}
		//unfriend a user
		public void unFriend(User user)
		{
			Scanner sc=new Scanner(System.in);
			NormalUserService n_user = new NormalUserService();
			List<String> obj1=n_user.seeAllFriends(user.getUser_name());
			System.out.println("Your Friends are");
			if(obj1==null){
				System.out.println("You Dont have any friends Yet");
			}
			else{
				for(String str:obj1)
					System.out.println(str);
				
				System.out.println("Do you want to unfriend any Friends 1--Yes 0--No");
				int choice=sc.nextInt();
				if(choice==1)
				{
					System.out.println("enter a valid user name from the List of names");
					String friend=sc.next();
					if(n_user.unFriend(friend))
						System.out.println("FriendShip terminated successfully");
				}
				}
		}
		//see all friend
		public void seeAllFriends(User user){
			NormalUserService n_user = new NormalUserService();
			List<String> obj = n_user.seeAllFriends(user.getUser_name());
			
			if(obj!=null){
				System.out.println("List of All Friends ");
				for(String str:obj){
					System.out.println(str);
				}
			}
			else
				System.out.println("NO Friends yet");
		}
		
		public void showForum(User user){
			
			ForumService obj = new ForumService();
			List<Forum> forum_list = obj.getForumList();
			if(forum_list==null){
				System.out.println("there is no forum");
			}
			else{
				// print the details of all forums
				int i = 1;
				for(Forum forum:forum_list){
					System.out.println(i+".");
					System.out.println("Forum Title : "+forum.getTopic());
					System.out.println("Forum Detail : "+forum.getSummary());
					System.out.println("Forum Creator : "+forum.getCreator_name());
					i++;
				}   // end of for
			}       // end of else
		}          // end of showForum
		
		// posting on any forum
		public void postComment(User user){
			int choice;
			Scanner sc = new Scanner(System.in);
			ForumService obj = new ForumService();
			List<Forum> forum_list = obj.getForumList();
			do{
				System.out.println("1. Post anything");
				System.out.println("2. Comment on a particular post");
				System.out.println("Enter your choice");
				choice=sc.nextInt();
				switch(choice){
				case 1:
					Forum forum = chooseForum(forum_list);
					createPost(forum,user.getUser_name());
					break;
				case 2:
					break;
				default:
					System.out.println("Incorrect Choice");
					break;
				}
				System.out.println("DO you want to continue 1-Yes 0- No");
				choice=sc.nextInt();
			}while(choice == 1);
		}
		//choose Forum
		public Forum chooseForum(List<Forum> forum_list){
			Scanner sc = new Scanner(System.in);
			if(forum_list == null){
				System.out.println("There are no forums");
			}
			else
			{
				System.out.println("Here are the List of forums");
				int i = 1;
				for(Forum forum:forum_list){
					System.out.println(i+".");
					System.out.println("Forum Title : "+forum.getTopic());
					i++;
					//System.out.println("FORUM ID : "+forum.getForum_id());
				}
				boolean checker=false;
				System.out.println("Choose any forum you want to post on");
				do{			
					String choose_forum = sc.next();
					for(Forum forum:forum_list){
						if(forum.getTopic().equalsIgnoreCase(choose_forum)){
							return forum;
						}
					}
					if(checker == false){
							System.out.println("Enter a valid Forum Name");
					}   // end of this else
				}while(checker == false);
			}  // end of else
			return null;
		}
		
		// create Post
		public void createPost(Forum forum,String user_name){
			Scanner kb = new Scanner(System.in);
			Post post = new Post();
			post.setForum_id(forum.getForum_id());
			post.setUsername(user_name);
			System.out.println("Enter Text for post : ");
			//kb.nextLine();
			post.setText_entry(kb.next());
			//create a service and when insert in db add date
			PostService post_ser=new PostService();
			if(post_ser.createPost(post)){
				System.out.println("You have succesfully posted");
			}
			else{
				System.out.println("Sorry something went wrong while Posting!!! Check Internet Connection");
				
			}// end of else
		}   // end of createPost
		
		// getting the value of rating
		public static int getRating(User user){
			PostService rating = new PostService();
			return rating.getRating(user.getUser_name());
		}
		
		//rating a particular post
	/*	public void ratePost(User user){
			System.out.println("Here is the List of Posts");
			seeAllPosts(user);
			List<String> dis = (new PostService()).seeAllPosts(user.getUser_name());
			System.out.println("Choose the post you want to rate"
			
		}   */
		//see all posts
		public void seeAllPosts(User user){
			PostService see_post = new PostService();
			ForumService forum_service = new ForumService();
			Scanner kb = new Scanner(System.in);
			int count = 0;
			List<Forum> forums = forum_service.getForumList();
			System.out.println("List of All Forum");
			
			
			Forum obj = chooseForum(forums);
			List<Post> posts = see_post.seeAllPosts(obj.getForum_id());
			if(posts.isEmpty()){
				System.out.println("There is no post in this Forum");
				return;
			}
			for(Post post : posts){
				System.out.println("Post : "+post.getText_entry());
				System.out.println("Creator : "+post.getUsername());
				System.out.println("Date : "+post.getPost_date());
			}
		}
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           