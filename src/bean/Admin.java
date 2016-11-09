package bean;
/*
  Main purpose of this class is to handle admin object
 */
public class Admin extends User{
	private String emergancy_number;
	private String user_type = "admin";
	public String getEmergancy_number() {
		return emergancy_number;
	}
	public void setEmergancy_number(String emergancy_number) {
		this.emergancy_number = emergancy_number;
	}
	public String getUser_type() {
		return user_type;
	}
	private void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	
	
}	
