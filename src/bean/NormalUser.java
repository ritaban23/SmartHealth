package bean;
/*
Main purpose of this class is to handle normal user object
*/
public class NormalUser extends User{
	private int karma;
	private String user_type = "new";
	public int getKarma() {
		return karma;
	}
	public void setKarma(int karma) {
		this.karma = karma;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	
	
}
