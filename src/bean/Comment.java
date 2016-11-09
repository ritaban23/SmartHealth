package bean;
import java.util.*;

public class Comment {
	private String post_username;
	private Date post_date;
	private String commenter_username;
	private String comment_text;
	private String photo_url;
	private String link_url;
	private String video_url;
	
	public String getPost_username() {
		return post_username;
	}
	public void setPost_username(String post_username) {
		this.post_username = post_username;
	}
	public Date getPost_date() {
		return post_date;
	}
	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}
	public String getCommenter_username() {
		return commenter_username;
	}
	public void setCommenter_username(String commenter_username) {
		this.commenter_username = commenter_username;
	}
	public String getComment_text() {
		return comment_text;
	}
	public void setComment_text(String comment_text) {
		this.comment_text = comment_text;
	}
	public String getPhoto_url() {
		return photo_url;
	}
	public void setPhoto_url(String photo_url) {
		this.photo_url = photo_url;
	}
	public String getLink_url() {
		return link_url;
	}
	public void setLink_url(String link_url) {
		this.link_url = link_url;
	}
	public String getVideo_url() {
		return video_url;
	}
	public void setVideo_url(String video_url) {
		this.video_url = video_url;
	}
}
