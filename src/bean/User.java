package bean;
/*
 	Main purpose of this class is to handle
 	 user object which is part of all user
 */
public abstract class User {
	private String user_name;
	private String primary_email;
	private String secondary_email;
	private String first_name;
	private String last_name;
	private String postal_address;
	private String about_me;
	private String image_url[] = new String[3];
	private boolean disable = false;
	private String password;
		
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isDisable() {
		return disable;
	}
	public void setDisable(boolean disable) {
		this.disable = disable;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPrimary_email() {
		return primary_email;
	}
	public void setPrimary_email(String primary_email) {
		this.primary_email = primary_email;
	}
	public String getSecondary_email() {
		return secondary_email;
	}
	public void setSecondary_email(String secondary_email) {
		this.secondary_email = secondary_email;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getPostal_address() {
		return postal_address;
	}
	public void setPostal_address(String postal_address) {
		this.postal_address = postal_address;
	}
	public String getAbout_me() {
		return about_me;
	}
	public void setAbout_me(String about_me) {
		this.about_me = about_me;
	}
	public String[] getImage_url() {
		return image_url;
	}
	public void setImage_url(String[] image_url) {
		this.image_url = image_url;
	}
}
