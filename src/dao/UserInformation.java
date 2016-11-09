package dao;
import java.util.*;
import bean.*;
public class UserInformation {
	private static Map<String,User> users = new HashMap<String,User>();
	
	public boolean addUser(User obj){
		if(users.containsKey(obj.getUser_name())){
			return false;
		}
		users.put(obj.getUser_name(),obj);
		return true;
	}
	public boolean checkParticularUser(User obj){
		boolean result = false;
		return users.containsKey(obj.getUser_name());
	}
	
}
