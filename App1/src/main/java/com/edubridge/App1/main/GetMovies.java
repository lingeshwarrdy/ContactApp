package com.edubridge.App1.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.edubridge.App1.Model.Movie;
import com.edubridge.App1.Utils.HibernateUtils;

public class GetMovies {
	public static void main(String[] args) {

		try (Session session = HibernateUtils.getSessionFactory().openSession()) {

			String hql =" from Movie";
			Query query=session.createQuery(hql);
			query.list().forEach(System.out::println);

		} catch (Exception e2) {

			e2.printStackTrace();

		}

		/*
		 * finally { session.close(); }
		 */
	}
}
