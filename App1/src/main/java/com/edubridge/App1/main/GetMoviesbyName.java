package com.edubridge.App1.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.edubridge.App1.Model.Movie;
import com.edubridge.App1.Utils.HibernateUtils;

public class GetMoviesbyName {
	public static void main(String[] args) {
		String title = "Kalki";

		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
//positional parameters
			String hql = "from Movie where hero=?1";
			// String hql =" from Movie where hero ='Prabhas'";
			Query query = session.createQuery(hql, Movie.class);
			query.setParameter(1, title);

			query.list().forEach(System.out::println);

		} catch (Exception e2) {

			e2.printStackTrace();

		}

		/*
		 * finally { session.close(); }
		 */
	}
}
