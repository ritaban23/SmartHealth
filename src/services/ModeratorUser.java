package services;

import java.util.List;

import dao.ModeratorDAO;
import dao.NormalUserDAO;
import bean.*;

public class ModeratorUser {
	public int addModeratorUser(User user){
		ModeratorDAO obj = new ModeratorDAO();
		return obj.addModerator((Moderator)user);
	}
	public int updateModeratorUser(Moderator user){
		ModeratorDAO obj = new ModeratorDAO();
		return obj.updateModerator(user);
	}
	public List<String> getAllUserName(String user_name){
		ModeratorDAO obj = new ModeratorDAO();
		return obj.getAllUserName(user_name);
	}
	public boolean addForum(Forum forum_obj){
		ModeratorDAO obj = new ModeratorDAO();
		return obj.addForum(forum_obj);
	}
}
