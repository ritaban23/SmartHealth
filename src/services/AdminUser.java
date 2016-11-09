package services;

import java.util.List;

import bean.*;
import dao.AdministratorDAo;
import dao.ModeratorDAO;

public class AdminUser {
	public int addAdminUser(User user){
		AdministratorDAo obj = new AdministratorDAo();
		return obj.addAdminUser((Admin)user);
	}
	public int updateAdminUser(Admin user){
		AdministratorDAo obj = new AdministratorDAo();
		return obj.updateAdmin(user);
	}
	public List<String> getAllUserName(String user_name){
		AdministratorDAo obj = new AdministratorDAo();
		return obj.getAllUserName(user_name);
	}
}
