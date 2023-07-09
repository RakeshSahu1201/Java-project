/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.tech.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Exam {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int examID;
	private String subject;
	private int totalQuestion;
	
	@OneToMany(mappedBy = "exam", cascade = CascadeType.ALL)
	private Set<Question> question;

	@OneToMany(mappedBy = "exam", cascade = CascadeType.ALL)
	private Set<Performance> performance;

	public int getExamID() {
		return examID;
	}

	public void setExamID(int examID) {
		this.examID = examID;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getTotalQuestion() {
		return totalQuestion;
	}

	public void setTotalQuestion(int totalQuestion) {
		this.totalQuestion = totalQuestion;
	}

	public Set<Question> getQuestion() {
		return question;
	}

	public void setQuestion(Set<Question> question) {
		this.question = question;
	}

	public Set<Performance> getPerformance() {
		return performance;
	}

	public void setPerformance(Set<Performance> performance) {
		this.performance = performance;
	}

	@Override
	public String toString() {
		return "Exam [examID=" + examID + ", subject=" + subject + ", totalQuestion=" + totalQuestion + "]";
	}

	
	
}
