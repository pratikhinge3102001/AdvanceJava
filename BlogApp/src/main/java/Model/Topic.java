package Model;

public class Topic {
	
	int topicid;
	String name,desc,uid;
	
	public Topic() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Topic(int topicid, String name, String desc, String uid) {
		super();
		this.topicid = topicid;
		this.name = name;
		this.desc = desc;
		this.uid = uid;
	}

	public int getTopicid() {
		return topicid;
	}

	public void setTopicid(int topicid) {
		this.topicid = topicid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}
	
	
	
	

}
