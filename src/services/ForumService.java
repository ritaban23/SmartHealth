package services;
import java.util.*;
import bean.*;
import dao.*;

public class ForumService {
	public List<Forum> getForumList(){
		ForumDAO obj = new ForumDAO();
		return obj.getForumList();
	}
	
}
