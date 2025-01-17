package com.edubridge.App1.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.edubridge.App1.Model.Movie;
import com.edubridge.App1.Utils.HibernateUtils;

public class GetMovie {
	public static void main(String[] args) {
		int eid = 1;

		try (Session session = HibernateUtils.getSessionFactory().openSession()) {

			Movie emp = session.get(Movie.class, eid);
			if (emp != null) {
				System.out.println(emp);
				System.out.println(emp.getMovieId());
				System.out.println(emp.getTitle());
				System.out.println(emp.getDirector());
				System.out.println(emp.getHero());

			} else {
				System.out.println("no movie found");
			}

		} catch (Exception e2) {

			e2.printStackTrace();

		}

		/*
		 * finally { session.close(); }
		 */
	}
}
