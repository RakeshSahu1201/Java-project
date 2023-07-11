/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.tech.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import quiz.tech.dbconnection.HibernateConnection;
import quiz.tech.entities.Exam;
import quiz.tech.entities.Performance;
import quiz.tech.entities.User;

public class PerformanceDao {

	public static Performance getPerformanceByUserIdAndExamId(int userId, int examId) {
		Session session = HibernateConnection.getFactory().openSession();
		User user = session.get(User.class, userId);
		Exam exam = session.get(Exam.class, examId);

		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Performance> query = builder.createQuery(Performance.class);

		Root<Performance> root = query.from(Performance.class);

		builder.equal(root.get("user"), user);
		builder.equal(root.get("exam"), exam);

		Query<Performance> query2 = session.createQuery(query);
		Performance result = query2.getSingleResult();
		session.close();
		return result;
	}

	public static List<Performance> getAllPerformers() {
		Session session = HibernateConnection.getFactory().openSession();

		Query<Performance> query = session.createQuery("From Performance", Performance.class);
		List<Performance> list = query.list();
		session.close();
		return list;
	}

	public static void savePerformance(Performance performer) {
		Session session = HibernateConnection.getFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(performer);
		tx.commit();
		session.close();
	}

	public static List<Performance> getPerformerByUserId(int userId) {
		Session session = HibernateConnection.getFactory().openSession();
		User user = session.get(User.class, userId);

		Query<Performance> query = session.createQuery("From Performance where user=: user", Performance.class);
		query.setParameter("user", user);
		List<Performance> list = query.list();
		session.close();
		return list;
	}

	public static List<Exam> getPerformerExamByUserId(int userId) {
		Session session = HibernateConnection.getFactory().openSession();
		User user = session.get(User.class, userId);

		Query<Exam> query = session.createQuery("Select exam From Performance p where p.user=: user", Exam.class);
		query.setParameter("user", user);
		List<Exam> list = query.list();
		session.close();
		return list;
	}

}
