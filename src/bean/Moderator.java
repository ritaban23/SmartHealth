package bean;
import java.util.*;
/*
Main purpose of this class is to handle moderator object
*/
public class Moderator extends User{
	private String user_type = "mod";
	private String emergency_number;
	private List<String> qualification = new ArrayList<String>();
	private void setUser_type(String user_type){
		this.user_type = user_type;
	}
	public String getUser_type() {
		return user_type;
	}
	public String getEmergency_number() {
		return emergency_number;
	}
	public void setEmergency_number(String emergency_number) {
		this.emergency_number = emergency_number;
	}
	public List<String> getQualification() {
		return qualification;
	}
	public void setQualification(List<String> qualification) {
		this.qualification = qualification;
	}
	
}
