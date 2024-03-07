package beans;

public class Comments {

	private int cid;
	private String text;
	private String topicid;
	private String uid;
	
	 public Comments() {
	    	
	    }
	public Comments(int cid, String text, String topicid, String uid) {
		super();
		this.cid = cid;
		this.text = text;
		this.topicid = topicid;
		this.uid = uid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTopicid() {
		return topicid;
	}
	public void setTopicid(String topicid) {
		this.topicid = topicid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
}
