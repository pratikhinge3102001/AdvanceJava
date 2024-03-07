package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="questions")


public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int qid;
	
	@Column
	String text;
	
	@Column
	String opt1;
	
	@Column
	String opt2;
	
	@Column
	String opt3;
	
	@Column
	String opt4;
	
	@Column
	String answer;
	
	@ManyToOne
	@JoinColumn(name = "subjectId")
	Subject subject;

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(String text, String opt1, String opt2, String opt3, String opt4, String answer,Subject subject) {
		super();
		this.text = text;
		this.opt1 = opt1;
		this.opt2 = opt2;
		this.opt3 = opt3;
		this.opt4 = opt4;
		this.answer = answer;
		this.subject = subject;
	}
	
	public Question(int qid, String opt1, String opt2, String opt3 , String opt4, String answer, String text) {
		super();
		this.qid = qid;
		this.text = text;
		this.opt1 = opt1;
		this.opt2 = opt2;
		this.opt3 = opt3;
		this.opt4 = opt4;
		this.answer=answer;
		
	}

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getOpt1() {
		return opt1;
	}

	public void setOpt1(String opt1) {
		this.opt1 = opt1;
	}

	public String getOpt2() {
		return opt2;
	}

	public void setOpt2(String opt2) {
		this.opt2 = opt2;
	}

	public String getOpt3() {
		return opt3;
	}

	public void setOpt3(String opt3) {
		this.opt3 = opt3;
	}

	public String getOpt4() {
		return opt4;
	}

	public void setOpt4(String opt4) {
		this.opt4 = opt4;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Question [qid=" + qid + ", text=" + text + ", opt1=" + opt1 + ", opt2=" + opt2 + ", opt3=" + opt3
				+ ", opt4=" + opt4 + ", answer=" + answer + ", subject=" + subject + "]";
	}

	
	
	

}
