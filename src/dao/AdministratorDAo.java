package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bean.Admin;

public class AdministratorDAo {

	public int addAdminUser(Admin obj){
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
			ps = connection.prepareStatement("insert into Administrator values(?,?)");
			ps.setString(1, obj.getUser_name());
			ps.setString(2, obj.getEmergancy_number());
	        if(ps.executeUpdate() == 0){
	        	return -1;
	        }
	        System.out.println("Basic detail of Admin has been submitted");
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
	        ps.setInt(16, 5);
	        ps.setInt(17, 0);
	        if(ps.executeUpdate() == 0){
	        	return -2;
	        }
	        System.out.println("Personal Details of Admin has been submitted");
			data_object.closeConnection(connection);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return 0;
	}
	public int updateAdmin(Admin admin)
	{
		DAOUtil data_object = new DAOUtil();
		Connection connection = data_object.getConnection();
		try
		{
			PreparedStatement ps = connection.prepareStatement("update  Administrator set Phone=? where Username=?");
			ps.setString(1, admin.getEmergancy_number());
			ps.setString(2, admin.getUser_name());
			
			if(ps.executeUpdate()==0){
					return -1;	
			}
			ps=connection.prepareStatement("update user set Password=?,Email1=?,Email2=?, FirstName=?, LastName=?, AboutMe=?, PhotoURL1=?, PhotoURL2=?,PhotoURL3=?, StreetNumber=?,StreetName=?, MajorMunicipality=?, GoverningDistrict=?,PostalArea=? where Username=?");
			
			//System.out.println("dsklf");
		    ps.setString(1, admin.getPassword());
		    ps.setString(2, admin.getPrimary_email());
		    ps.setString(3, admin.getSecondary_email());
		    ps.setString(4, admin.getFirst_name());
		    ps.setString(5, admin.getLast_name());
		    ps.setString(6, admin.getAbout_me());
		    ps.setString(7, admin.getImage_url()[0]);
		    ps.setString(8, admin.getImage_url()[1]);
		    ps.setString(9, admin.getImage_url()[2]);
		    ps.setString(10, admin.getPostal_address());
		    ps.setString(11, admin.getPostal_address());
		    ps.setString(12, admin.getPostal_address());
		    ps.setString(13, admin.getPostal_address());
		    ps.setString(14, admin.getPostal_address());
		    ps.setString(15,admin.getUser_name());
		    //System.out.println("hhhh");
		    
		    if(ps.executeUpdate()==0)
				return -2;
			else
			{
				System.out.println("Admin details updates successfully");
				data_object.closeConnection(connection);
			}	
		    System.out.println("Done");
			
		}
		catch(Exception e)
		{
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
}
