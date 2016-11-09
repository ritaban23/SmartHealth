package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

import bean.*;
public class PostDAO {

	// generating the post
	public boolean createPost(Post post){
		DAOUtil data_object = new DAOUtil();
		Connection connection = data_object.getConnection();
		try{
			PreparedStatement ps = connection.prepareStatement("insert into post values(?,?,?,?,?,?,?)");
			ps.setString(1,post.getUsername());
			ps.setTimestamp(2, new Timestamp((new Date()).getTime()));
			ps.setInt(3, post.getForum_id());
			ps.setString(4,post.getText_entry());
			ps.setString(5,null);
			ps.setString(6, null);
			ps.setString(7, null);
			if(ps.executeUpdate()!=0)
				return true;
		}
		catch(Exception e){
			e.getMessage();
		}
		return false;
	}
	
	// displaying all posts
	public List<Post> seeAllPosts(int forumid){
		DAOUtil data_object = new DAOUtil();
		Connection connection = data_object.getConnection();
		List<Post> obj = new ArrayList<Post>();
		try{
			PreparedStatement ps = connection.prepareStatement("select * from post where forumId = ?");
			ps.setInt(1, forumid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Post tmp = new Post();
				tmp.setUsername(rs.getString(1));
				tmp.setPost_date(rs.getTimestamp(2));
				tmp.setForum_id(rs.getInt(3));
				tmp.setText_entry(rs.getString(4));
				tmp.setPhoto_location(rs.getString(5));
				tmp.setLink_location(rs.getString(6));
				tmp.setVideo_location(rs.getString(7));
				obj.add(tmp);
			}
			return obj;
		}
		catch(Exception e){
			e.getMessage();
		}
		return null;
	}
	
	// getting the particular user rating
	public int getRating(String user){
		DAOUtil data_object = new DAOUtil();
		Connection connection = data_object.getConnection();
		int count = 0;
		try{
			PreparedStatement ps = connection.prepareStatement("select Stars from rating where Post_username = ? ");
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				count++;
				return rs.getInt(1);
			}
		}
		catch(Exception e){
			e.getMessage();
		}
		return 0;
	}
}

