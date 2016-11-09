package bean;
import java.util.*;

public class Post {
	private String username;
	private int forum_id;
	private Date post_date;
	private String text_entry;
	private String photo_location;
	private String link_location;
	private String video_location;
	
	public Date getPost_date() {
		return post_date;
	}
	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getForum_id() {
		return forum_id;
	}
	public void setForum_id(int forum_id) {
		this.forum_id = forum_id;
	}
	public String getText_entry() {
		return text_entry;
	}
	public void setText_entry(String text_entry) {
		this.text_entry = text_entry;
	}
	public String getPhoto_location() {
		return photo_location;
	}
	public void setPhoto_location(String photo_location) {
		this.photo_location = photo_location;
	}
	public String getLink_location() {
		return link_location;
	}
	public void setLink_location(String link_location) {
		this.link_location = link_location;
	}
	public String getVideo_location() {
		return video_location;
	}
	public void setVideo_location(String video_location) {
		this.video_location = video_location;
	}
	
	
}
