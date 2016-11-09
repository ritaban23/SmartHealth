package services;
import bean.*;
import dao.*;
public class LoginService {
	public User getLogin(String user_name,String password){
		LoginDAO obj = new LoginDAO();
		return obj.login(user_name,password);
	}
	public int quitUser(String user_name){
		LoginDAO obj = new LoginDAO();
		return obj.quitSystem(user_name);
	}
}
