package entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="subjects")

public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	int subjectId;
	
	@Column
	String name;
	
	@Column
	String description;
	
	@OneToMany(mappedBy = "subject")
	@Cascade(value = CascadeType.ALL)
	Set<Question> questions;

	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subject(String name, Set<Question> questions) {
		
		this.name = name;
		for(Question qu : questions)
			qu.setSubject(this);
		this.questions = questions;
	}
	
	public Subject(String name) {
		super();
		this.name = name;
	}
	
	
	public Subject(String name, String description) {
		this.name = name ;
		this.description = description;
	}

	public void Question(Set<Question> questions) {
		for(Question qi : questions)
			qi.setSubject(this); 
		this.questions = questions;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
	
	
	
	
	
	

}
