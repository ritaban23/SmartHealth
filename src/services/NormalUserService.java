package services;

import java.util.*;
import bean.*;
import dao.*;
public class NormalUserService {
	public int addNormalUser(User user){
		NormalUserDAO obj = new NormalUserDAO();
		return obj.addNormalUser(((NormalUser)user));
	}
	public int updateNormalUser(NormalUser user){
		NormalUserDAO obj = new NormalUserDAO();
		return obj.updateNormalUser(user);
	}
	public List<String> getAllUserName(String user_name){
		NormalUserDAO obj = new NormalUserDAO();
		return obj.getAllUserName(user_name);
	}
	public boolean sendRequest(String user,String r_user){
		NormalUserDAO obj = new NormalUserDAO();
		return obj.sendRequest(user,r_user);
	}
	public List<String> seeSendRequest(String user_name){
		NormalUserDAO obj = new NormalUserDAO();
		return obj.seeSendRequest(user_name);
	}
	public List<String> seeAllRequest(String user_name)
	{
		NormalUserDAO obj=new NormalUserDAO();
		return obj.seeAllRequest(user_name);
		
	}
	public List<String> findFriendForRequest(String user_name){
		NormalUserDAO obj = new NormalUserDAO();
		return obj.findFriendForRequest(user_name);
	}
	public boolean acceptRequest(String user_name,String ruser)
	{
		NormalUserDAO obj=new NormalUserDAO();
		return obj.acceptRequest(user_name,ruser);
		
	}
	public List<String> seeAllFriends(String user)
	{
		NormalUserDAO obj=new NormalUserDAO();
		return obj.seeAllFriends(user);
	}
	public boolean unFriend(String user){
		NormalUserDAO obj=new NormalUserDAO();
		return obj.unFriend(user);
	}
	public boolean updateDatum(List<Datum> dat){
		NormalUserDAO obj = new NormalUserDAO();
		return obj.updateDatum(dat);
	}
	public List<String> seeHealthData(String user){
		NormalUserDAO obj=new NormalUserDAO();
		return obj.seeHealthData(user);
	}
}
