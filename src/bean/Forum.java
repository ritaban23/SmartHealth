package bean;

public class Forum {
	private int forum_id;
	private String topic;
	private String url;
	private String summary;
	private String creator_name;
	
	public Forum(){
		
	}	
	public Forum(String topic, String url, String summary, String creator_name) {
		super();
		forum_id = (int)((new java.util.Date()).getTime());
		this.topic = topic;
		this.url = url;
		this.summary = summary;
		this.creator_name = creator_name;
	}
	public int getForum_id() {
		return forum_id;
	}
	public void setForum_id(int forum_id) {
		this.forum_id = forum_id;
	} 
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getCreator_name() {
		return creator_name;
	}
	public void setCreator_name(String creator_name) {
		this.creator_name = creator_name;
	}
}
