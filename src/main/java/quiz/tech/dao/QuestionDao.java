/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.tech.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import quiz.tech.dbconnection.HibernateConnection;
import quiz.tech.entities.Exam;
import quiz.tech.entities.Question;

/**
 *
 * @author spsub
 */
public class QuestionDao {

	public static List<Question> getQuestionsByExamId(Exam exam) {

		Session session = HibernateConnection.getFactory().openSession();
		Query<Question> query = session.createQuery("From Question where exam=:exam", Question.class);
		query.setParameter("exam", exam);

		List<Question> list = query.list();
		session.close();

		return list;

	}

}
