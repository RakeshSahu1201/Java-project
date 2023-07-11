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
import quiz.tech.entities.Performance;
import quiz.tech.entities.User;

public class UserDao {

	public static String ValidateUser(User user) {
		Session session = HibernateConnection.getFactory().openSession();

		System.out.println("user is " + user);

		Query<String> query = session.createQuery(
				"Select userName From User where userId=: uId and password =: pwd and userType =:type", String.class);
		query.setParameter("uId", user.getUserId());
		query.setParameter("pwd", user.getPassword());
		query.setParameter("type", user.getUserType());

		String userName = query.getSingleResult();
		session.close();
		return userName;
	}

	public static int addUser(User user) {
		Session session = HibernateConnection.getFactory().openSession();

		Transaction tx = session.beginTransaction();

		int id = (Integer) session.save(user);

		tx.commit();
		session.close();
		return id;
	}

	public static User getUserByUserId(int userId) {
		Session session = HibernateConnection.getFactory().openSession();

		User user = session.get(User.class, userId);

		session.close();

		return user;
	}

	public static List<User> getUsersByType() {
		Session session = HibernateConnection.getFactory().openSession();

		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		Root<Performance> root = query.from(Performance.class);
		query.select(root.get("user"));

		Query<User> result = session.createQuery(query);
		List<User> list = result.list();
		session.close();
		return list;

	}

	public static boolean updatePassword(User user, String password) {
		Session session = HibernateConnection.getFactory().openSession();

		Query<User> query = session.createQuery("From User where userId=:id and password=:password", User.class);
		query.setParameter("id", user.getUserId());
		query.setParameter("password", password);

		
		if (query.list().isEmpty())
			return false;

		Transaction tx = session.beginTransaction();
		session.clear();
		session.update(user);

		tx.commit();
		session.close();
		return true;
	}
}
