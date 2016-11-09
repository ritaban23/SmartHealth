package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

import bean.Datum;
import bean.NormalUser;
public class NormalUserDAO {
	
	// adding a normal user
	public int addNormalUser(NormalUser obj){
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
			ps = connection.prepareStatement("insert into EndUser values(?,?,?)");
			ps.setString(1, obj.getUser_name());
			ps.setInt(2, obj.getKarma());
			java.sql.Date create_date = new java.sql.Date((new Date()).getTime());             
	        ps.setDate(3, create_date);
	        if(ps.executeUpdate() == 0){
	        	return -1;
	        }
	        System.out.println("Basic detail of Normal User has been submitted");
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
	        ps.setInt(16, 1);
	        ps.setInt(17, 0);
	        if(ps.executeUpdate() == 0){
	        	return -2;
	        }
	        System.out.println("Personal Details of normal user has been submitted");
			data_object.closeConnection(connection);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return 0;
	}
	//update normal user
	public int updateNormalUser(NormalUser obj)
	{
		DAOUtil data_object = new DAOUtil();
		Connection connection = data_object.getConnection();
		try{
			PreparedStatement ps = connection.prepareStatement("update enduser set Karma=? where Username=? ");
			ps.setString(2, obj.getUser_name());
			ps.setInt(1, obj.getKarma());
			
	        if(ps.executeUpdate() == 0){
	        	return -1;
	        }
	        System.out.println("Karma of User is Updated");
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
	        System.out.println("Personal Details of normal user has been updated");
			data_object.closeConnection(connection);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return 0;
	}
	//getting all usernames from the database
	public List<String> getAllUserName(String user_name){
		List<String> obj = new ArrayList<String>();
		DAOUtil data_object = new DAOUtil();
		Connection connection = data_object.getConnection();
		try{
			PreparedStatement ps = connection.prepareStatement("select Username from User where Username <> ? and UserTypeID <> ? and UserTypeID <> ? and Status=0");
			PreparedStatement ps1 = connection.prepareStatement("");
			ps.setString(1, user_name);
			ps.setInt(2, 4);
			ps.setInt(3, 5);
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
	// send request to your friends
	public boolean sendRequest(String suser,String ruser){
		//one more check have to be there that if they are already friends then we dont need to execute the insertion query
		DAOUtil data_object = new DAOUtil();
		Connection connection = data_object.getConnection();
		
		try{
			PreparedStatement ps = connection.prepareStatement("insert into Friendship values(?,?,?,?,?,?,?)");
			ps.setString(1, suser);
			ps.setString(2, ruser);
			ps.setTimestamp(3, new Timestamp((new Date()).getTime()));
			ps.setTimestamp(4, null);
			ps.setTimestamp(6, null);
			ps.setTimestamp(5, null);
			ps.setTimestamp(7, null);
			if(ps.executeUpdate() != 0){
				return true;
			}
				
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	//for FindFriend for sending request	
	public List<String> findFriendForRequest(String user_name){
		List<String> friendList = new LinkedList<String>();
		DAOUtil data_object = new DAOUtil();
		Connection connection = data_object.getConnection();
		try{
			PreparedStatement ps = connection.prepareStatement("select * from User where Username=?");
			ps.setString(1, user_name);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				friendList.add(rs.getString(1));
			}
			ps = connection.prepareStatement("select * from friendship where Requested_Username=? OR Requester_Username=?");
			ps.setString(1, user_name);
			ps.setString(2, user_name);
			rs = ps.executeQuery();
			while(rs.next()){
				if(rs.getString(1).equals(user_name)){
					friendList.remove(rs.getString(2));
				}else{
					friendList.remove(rs.getString(1));
				}
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return friendList;
	}
	
	// see all the sent request
	public List<String> seeSendRequest(String suser){
		List<String> obj = new ArrayList<String>();
		DAOUtil data_object = new DAOUtil();
		Connection connection = data_object.getConnection();
		try{
			PreparedStatement ps = connection.prepareStatement("select Requested_Username from Friendship where Requester_Username = ?");
			ps.setString(1, suser);
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
	// see all the pending friend request
	public List<String> seeAllRequest(String suser){
		List<String> obj = new ArrayList<String>();
		DAOUtil data_object = new DAOUtil();
		Connection connection = data_object.getConnection();
		int count=0;
		try{
			PreparedStatement ps = connection.prepareStatement("select Requester_Username from Friendship where Requested_Username = ? and WhenRejected is NULL and WhenConfirmed is NULL and WhenUnfriended is NULL");
			ps.setString(1, suser);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				count++;
				obj.add(rs.getString(1));
			}
			if(count==0)
				System.out.println("There are no Friend Requests");
			return obj;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	//accept all the requests
	public boolean acceptRequest(String suser,String ruser){
		DAOUtil data_object = new DAOUtil();
		Connection connection = data_object.getConnection();
		try{
			PreparedStatement ps = connection.prepareStatement("Update friendship set WhenConfirmed=? where (Requester_Username=?) and Requested_Username = ? and WhenConfirmed is NULL");
			ps.setTimestamp(1, new Timestamp((new Date()).getTime()));
			ps.setString(2,suser);
			ps.setString(3, ruser);
			if(ps.executeUpdate()!=0)
				return true;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	// see all your friends
	public List<String> seeAllFriends(String suser){
		DAOUtil data_object = new DAOUtil();
		List<String> obj = new ArrayList<String>();
		Connection connection = data_object.getConnection();
		try
		{
			PreparedStatement ps=connection.prepareStatement("select Requester_Username from friendship where Requested_Username=? and WhenConfirmed is not null");
			ps.setString(1,suser);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				obj.add(rs.getString(1));
			}
			ps=connection.prepareStatement("select Requested_Username from friendship where Requester_Username=? and WhenConfirmed is not null");
			ps.setString(1,suser);
			rs=ps.executeQuery();
			while(rs.next()){
				obj.add(rs.getString(1));
			}
			/*if(!rs.next()){
				ps=connection.prepareStatement("select Requested_Username from friendship where Requester_Username=? and WhenConfirmed is not null");
				ps.setString(1,suser);
				rs=ps.executeQuery();
			}
			else
			{
				do
				{
					obj.add(rs.getString(1));
				}
				while(rs.next());
			}*/
			return obj;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return null;
	}
	//unfriend a certain friend
	public boolean unFriend(String user){
		DAOUtil data_object = new DAOUtil();
		Connection connection = data_object.getConnection();
		try
		{
			PreparedStatement ps=connection.prepareStatement("update friendship set WhenUnfriended=?,WhenConfirmed=? where Requester_Username=? and WhenConfirmed is not null");
			ps.setTimestamp(1,new Timestamp((new Date()).getTime()));
			ps.setTimestamp(2,null);
			ps.setString(3, user);
			if(ps.executeUpdate()!=0)
				return true;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return false;
	}
	//update your medical problems
	public boolean updateDatum(List<Datum> dat){
		DAOUtil data_object = new DAOUtil();
		Connection connection = data_object.getConnection();
		try{
			PreparedStatement ps = null;
			for(Datum obj:dat){
				ps = connection.prepareStatement("insert into datum values(?,?,?,?,?)");
				ps.setLong(1, obj.getDatum_id());
				ps.setString(2, obj.getUsername());
				ps.setInt(3, obj.getProperty_id());
				ps.setString(4, obj.getValue());
				ps.setDate(5, new java.sql.Date((new Date()).getTime()));
				if(ps.executeUpdate() == 0){
					return false;
				}
			}
			data_object.closeConnection(connection);
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("All things updated");
		return true;
	}
	// It gets the list of all the medical history of the user.
	public List<String> seeHealthData(String user){
		DAOUtil data=new DAOUtil();
		List<String> obj=new ArrayList<String>();
		Connection connection=data.getConnection();
		try{
			PreparedStatement ps=connection.prepareStatement("select Value from datum where Username=?");
			ps.setString(1, user);
			ResultSet rs=ps.executeQuery();
			if(!rs.next()){
				return null;
			}else{	
				do{
					obj.add(rs.getString(1));
				}while(rs.next());					
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		if(!(obj.isEmpty()))
			return obj;
		return null;
	}
	
}     
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        