package dao;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import bean.Forum;
import bean.Moderator;
import controller.HomeController;;

public class ModeratorDAO {

	
	public int addModerator(Moderator obj){
		DAOUtil data_object = new DAOUtil();
		Connection connection = data_object.getConnection();
		try{
			PreparedStatement ps = connection.prepareStatement("select * from User where Email1 = ?");
			ps.setString(1, obj.getPrimary_email());
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				System.out.println("Primary Email id is not unique");
				return -3;
			}
			ps = connection.prepareStatement("insert into Moderator values(?,?)");
			ps.setString(1, obj.getUser_name());
			ps.setString(2, obj.getEmergency_number());
	        if(ps.executeUpdate() == 0){
	        	return -1;
	        }
	        System.out.println("Basic detail moderator has been submitted");
	        ps = connection.prepareStatement("insert into User values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	        ps.setString(1, obj.getUser_name());
	        ps.setString(2, obj.getPassword());
	        ps.setString(3, obj.getPrimary_email());
	        ps.setString(4, obj.getSecondary_email());
	        ps.setString(5, obj.getFirst_name());
	        ps.setString(6, obj.getLast_name());
	        ps.setString(7, obj.getAbout_me());
	        ps.setString(8, obj.getImage_url()[0]);
	        ps.setString(9, obj.getImage_url()[1]);
	        ps.setString(10, obj.getImage_url()[2]);
	        ps.setString(11, "Not available");
	        ps.setString(12, obj.getPostal_address());
	        ps.setString(13, obj.getPostal_address());
	        ps.setString(14, obj.getPostal_address());
	        ps.setString(15, obj.getPostal_address());
	        ps.setInt(16, 4);
	        ps.setInt(17, 0);
	        if(ps.executeUpdate() == 0){
	        	return -2;
	        }
	        System.out.println("Personal detail of moderator has been submitted");
	        List<String> qualification = obj.getQualification();
	        for(String str:qualification){
	        	System.out.println(str);
	        	if(str.equalsIgnoreCase("md")){
	        		ps = connection.prepareStatement("insert into ModeratorQualification values(?,?,?)");
			        ps.setInt(1, 1);
			        ps.setString(2, obj.getUser_name());
			        ps.setTimestamp(3, new Timestamp((new Date()).getTime()));
			        if(ps.executeUpdate() == 0){
			        	return -3;
			        }
			        System.out.println("MD qualifiction added");
	        	}else if(str.equalsIgnoreCase("phd")){
	        		ps = connection.prepareStatement("insert into ModeratorQualification values(?,?,?)");
			        ps.setInt(1, 2);
			        ps.setString(2, obj.getUser_name());
			        ps.setTimestamp(3, new Timestamp((new Date()).getTime()));
			        if(ps.executeUpdate() == 0){
			        	return -3;
			        }
			        System.out.println("Ph.D qualifiction added");
	        	}
	        }
	        System.out.println("Complete Details of Moderator added");
			data_object.closeConnection(connection);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return 0;
	}
	public int updateModerator(Moderator obj)
	{
		DAOUtil data_object = new DAOUtil();
		Connection connection = data_object.getConnection();
		try{
			PreparedStatement ps = connection.prepareStatement("update Moderator set Phone = ? where Username=?");
			ps.setString(1, obj.getEmergency_number());
			ps.setString(2, obj.getUser_name());
	        if(ps.executeUpdate() == 0){
	        	System.out.println("inside");
	        	return -1;
	        }
	        System.out.println("Mode");
	        System.out.println("Basic detail of moderator has been updated");
	        ps=connection.prepareStatement("update user set Password=?,Email1=?,Email2=?, FirstName=?, LastName=?, AboutMe=?, PhotoURL1=?, PhotoURL2=?,PhotoURL3=?, StreetNumber=?,StreetName=?, MajorMunicipality=?, GoverningDistrict=?,PostalArea=? where Username=?");
			
	        ps.setString(1, obj.getPassword());
	        ps.setString(2, obj.getPrimary_email());
	        ps.setString(3, obj.getSecondary_email());
	        ps.setString(4, obj.getFirst_name());
	        ps.setString(5, obj.getLast_name());
	        ps.setString(6, obj.getAbout_me());
	        ps.setString(7, obj.getImage_url()[0]);
	        ps.setString(8, obj.getImage_url()[1]);
	        ps.setString(9, obj.getImage_url()[2]);
	        ps.setString(10, obj.getPostal_address());
	        ps.setString(11, obj.getPostal_address());
	        ps.setString(12, obj.getPostal_address());
	        ps.setString(13, obj.getPostal_address());
	        ps.setString(14, obj.getPostal_address());
	        ps.setString(15, obj.getUser_name());
	        if(ps.executeUpdate() == 0){
	        	return -2;
	        }
	        System.out.println("Personal detail of moderator has been Updated");
	       
			data_object.closeConnection(connection);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return 0;
	}
	public List<String> getAllUserName(String user_name){
		List<String> obj = new ArrayList<String>();
		DAOUtil data_object = new DAOUtil();
		Connection connection = data_object.getConnection();
		try{
			PreparedStatement ps = connection.prepareStatement("select Username from User where Username <> ? and UserTypeID = ?");
			ps.setString(1, user_name);
			ps.setInt(2, 5);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				obj.add(rs.getString(1));
			}
			return obj;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public boolean addForum(Forum forum_obj){
		DAOUtil data_object = new DAOUtil();
		Connection connection = data_object.getConnection();
		try{
			System.out.println("p1");
			PreparedStatement ps = connection.prepareStatement("insert into forum (ForumID,Topic,URL,Summary,WhenCreated,CreatedByModerator_Username) values (?,?,?,?,?,?)");
			ps.setInt(1, forum_obj.getForum_id());
			ps.setString(3, forum_obj.getUrl());
			ps.setString(2,forum_obj.getTopic());
			ps.setString(4, forum_obj.getSummary());
			ps.setDate(5,  new java.sql.Date((new Date()).getTime()));
			ps.setString(6, forum_obj.getCreator_name());
			System.out.println("p2");
			if(ps.executeUpdate() == 0){
				System.out.println("p3");
				return false;				
			}
			connection.close();
		}catch(Exception e){
			e.getMessage();
		
		}
		return true;
	}
}
