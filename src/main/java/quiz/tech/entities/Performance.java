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
import javax.persistence.ManyToOne;

@Entity
public class Performance {

	@Id
	@Column(name = "perform_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int performId;
	private int right;
	private int wrong;
	private int unattemped;
	private double percentage;

	@ManyToOne(cascade = CascadeType.MERGE)
	private User user;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Exam exam;

	public int getPerformId() {
		return performId;
	}

	public void setPerformId(int performId) {
		this.performId = performId;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public int getWrong() {
		return wrong;
	}

	public void setWrong(int wrong) {
		this.wrong = wrong;
	}

	public int getUnattemped() {
		return unattemped;
	}

	public void setUnattemped(int unattemped) {
		this.unattemped = unattemped;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	@Override
	public String toString() {
		return "Performance [performId=" + performId + ", right=" + right + ", wrong=" + wrong + ", unattemped="
				+ unattemped + ", percentage=" + percentage + "]";
	}

	
	
	

}
