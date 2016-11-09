package services;
import controller.*;
import dao.*;

import java.util.List;

import bean.*;
public class PostService {
	
	// calling the DAO method
	public boolean createPost(Post post){
		PostDAO obj = new PostDAO();
		return obj.createPost(post);
	}
	
	public List<Post> seeAllPosts(int forum){
		PostDAO obj = new PostDAO();
		return obj.seeAllPosts(forum);
	}
	
	public int getRating(String user){
		PostDAO obj = new PostDAO();
		return obj.getRating(user);
	}
}
