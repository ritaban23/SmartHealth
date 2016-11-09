package dao;
import java.sql.Connection;
import java.util.*;
import java.sql.*;

import bean.*;

public class ForumDAO {

	public List<Forum> getForumList(){
		DAOUtil data_object = new DAOUtil();
		Connection connection = data_object.getConnection();
		List<Forum> forum_list = new ArrayList<Forum>();
		try{
			PreparedStatement ps = connection.prepareStatement("select * from Forum");
			ResultSet rs = ps.executeQuery();
			if(!rs.next()){
				return null;
			}else{
				do{
					Forum forum_obj = new Forum();
					forum_obj.setTopic(rs.getString(2));
					forum_obj.setSummary(rs.getString(4));
					forum_obj.setForum_id(rs.getInt(1));
					forum_obj.setUrl(rs.getString(3));
					forum_obj.setCreator_name(rs.getString(7));
					forum_list.add(forum_obj);
				}while(rs.next());
			}
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return forum_list;
	}
}
