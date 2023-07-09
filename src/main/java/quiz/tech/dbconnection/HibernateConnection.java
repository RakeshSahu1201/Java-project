/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.tech.dbconnection;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConnection {
	private static SessionFactory factory;

	static {
		try {
			Configuration cfg = new Configuration();
			cfg.configure("resources/hibernate.cfg.xml");
			factory = cfg.buildSessionFactory();
			System.out.println("factory created successfully.");
		} catch (HibernateException e) {
			System.out.println("Error while configuring");
			e.printStackTrace();
		}
	}

	public static SessionFactory getFactory() {
		return factory;
	}


	public static void closeConnection() {
		try {
			if (factory != null)
				factory.close();
		} catch (HibernateException ex) {
			System.out.println("Error while closing factory.");
			ex.printStackTrace();
		}
	}
}
