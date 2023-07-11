/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.tech.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import quiz.tech.dbconnection.HibernateConnection;
import quiz.tech.entities.Exam;
import quiz.tech.entities.Performance;
import quiz.tech.entities.User;

public class ExamDao {

	public static int addExam(Exam exam) {

		Session session = HibernateConnection.getFactory().openSession();

		Transaction tx = session.beginTransaction();

		int id = (Integer) session.save(exam);

		tx.commit();
		session.close();
		return id;
	}

	public static void updateExam(Exam exam) {

		Session session = HibernateConnection.getFactory().openSession();

		Transaction tx = session.beginTransaction();

		session.merge(exam);

		tx.commit();
		session.close();
	}

	public static Exam getExamByExamId(int examId) {

		Session session = HibernateConnection.getFactory().openSession();

		Exam exam = session.get(Exam.class, examId);
		session.close();
		return exam;
	}

	public static void discardExamById(int examId) {

		Session session = HibernateConnection.getFactory().openSession();

		Transaction tx = session.beginTransaction();

		Exam exam = session.get(Exam.class, examId);

		session.delete(exam);

		tx.commit();
		session.close();
	}

	public static List<Integer> getExamIdBySubject(String subject) {

		Session session = HibernateConnection.getFactory().openSession();

		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Integer> query = builder.createQuery(Integer.class);
		Root<Exam> root = query.from(Exam.class);
		query.select(root.get("examID"));
		Predicate predicate = builder.equal(root.get("subject"), subject);
		query.where(predicate);

		Query<Integer> list = session.createQuery(query);
		List<Integer> resultList = list.getResultList();
		session.close();
		return resultList;

	}
	

//	public static List<Integer> getExamIdBySubjectForStudent(int userId, String subject) {
//
//		Session session = HibernateConnection.getFactory().openSession();
//		User user = session.get(User.class, userId);
//		List<Exam> performers = PerformanceDao.getPerformerExamByUserId(userId);
//
//		CriteriaBuilder builder = session.getCriteriaBuilder();
//		CriteriaQuery<Integer> query = builder.createQuery(Integer.class);
//		Root<Exam> exam = query.from(Exam.class);
//		Root<Performance> perform = query.from(Performance.class);
//		
//		query.select(exam.get("examID"));
//
//		Predicate predicate = builder.equal(exam.get("subject"), subject);
//		Predicate predicate3 = builder.not(exam.get("examID"), performers);
//
//		query.where(predicate, predicate3);
//
//		Query<Integer> query2 = session.createQuery(query);
//		List<Integer> list = query2.getResultList();
//		session.close();
//		return list;
//	}

	

	public static List<Exam> getExamIdByUserForStudent(int userId) {

		Session session = HibernateConnection.getFactory().openSession();
		User user = session.get(User.class, userId);

		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Exam> query = builder.createQuery(Exam.class);
		Root<Performance> perform = query.from(Performance.class);

		query.select(perform.get("exam"));

		Predicate predicate = builder.equal(perform.get("user"), user);

		query.where(predicate);

		Query<Exam> query2 = session.createQuery(query);
		List<Exam> list = query2.getResultList();
		session.close();
		return list;
	}
}
