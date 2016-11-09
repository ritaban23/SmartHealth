package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Admin;
import bean.Moderator;
import bean.NormalUser;
import bean.User;

public class LoginDAO {

	public User login(String user_name,String password){
		DAOUtil data_object = new DAOUtil();
		Connection connection = data_object.getConnection();
		try{
			PreparedStatement ps = connection.prepareStatement("select * from User where Email1 = ? and password = ?");
			ps.setString(1, user_name);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			//System.out.println("After exeq");
			if(rs.next()){
				//System.out.println(rs.getString(1));
				//System.out.println("inside if");				
				//System.out.println(rs.getInt("UserTypeID"));
				int user_type = rs.getInt("UserTypeID");
				//System.out.println(rs.getInt("UserTypeID"));
				
				User user;
				if(user_type == 4){
					user = new Moderator();
				}else if(user_type == 5){
					user = new Admin();
				}else{
					user = new NormalUser();
				}
				if(rs.getInt(17) == 1){
					user.setDisable(true);
					return user;
				}
				user.setPassword(password);
				user.setUser_name(rs.getString(1));
				user.setPrimary_email(rs.getString(3));
				user.setSecondary_email(rs.getString(4));
				user.setFirst_name(rs.getString(5));
				user.setLast_name(rs.getString(6));
				user.setAbout_me(rs.getString(7));
				String img_url[] = new String[3];
				img_url[0] = rs.getString(8);
				img_url[1] = rs.getString(9);
				img_url[2] = rs.getString(10);	
				user.setImage_url(img_url);
				user.setPostal_address(rs.getString(11));
				if(user instanceof NormalUser){
					ps = connection.prepareStatement("select * from EndUser where Username = ?");
					ps.setString(1, user_name);
					rs = ps.executeQuery();
					if(rs.next()){
						((NormalUser) user).setKarma(rs.getInt(2));
					}
				}else if(user instanceof Moderator){
					ps = connection.prepareStatement("select * from Moderator where Username = ?");
					ps.setString(1, user_name);
					rs = ps.executeQuery();
					if(rs.next()){
						((Moderator) user).setEmergency_number(rs.getString(2));
					}
					ps = connection.prepareStatement("select * from ModeratorQualification where Username = ?");
					ps.setString(1, user_name);
					rs = ps.executeQuery();
					List<String> qual = new ArrayList<String>();
					while(rs.next()){
						if(rs.getInt(1) == 1){
							qual.add("md");
						}else{
							qual.add("phd");
						}
					}
					((Moderator) user).setQualification(qual);
				}else{
					ps = connection.prepareStatement("select * from Administrator where Username = ?");
					ps.setString(1, user_name);
					rs = ps.executeQuery();
					if(rs.next()){
						((Admin) user).setEmergancy_number(rs.getString(2));
					}
				}
				//System.out.println("done");
				return user;
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return null;
	}
	public int quitSystem(String user_name){
		DAOUtil data_object = new DAOUtil();
		Connection connection = data_object.getConnection();
		try{
			PreparedStatement ps = connection.prepareStatement("update user set Status=? where Username=?");
			ps.setInt(1, 1);
			ps.setString(2,user_name);
			if(ps.executeUpdate()==0)
				return -1;
			else{
				System.out.println("You have deactivated successfully");
				return 1;
	        }
		}
		catch(Exception  e)
		{
			System.out.println(e.getMessage());
		}
	    return 0;
	}
	public void tmp(){
		DAOUtil d = new DAOUtil();
		Connection con = d.getConnection();
		System.out.println("tmp");
		try{
			PreparedStatement ps = con.prepareStatement("select * from user");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString(1));
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
}
