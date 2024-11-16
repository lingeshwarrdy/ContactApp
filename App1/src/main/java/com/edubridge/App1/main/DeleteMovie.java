package com.edubridge.App1.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.edubridge.App1.Model.Movie;
import com.edubridge.App1.Utils.HibernateUtils;

public class DeleteMovie {
	public static void main(String[] args) {
		int eid = 2;
		
		Transaction tx =null;

		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			
			tx =session.beginTransaction();

			Movie m = session.get(Movie.class, eid);
			if (m != null) {
				session.remove(m);
				tx.commit();
				System.out.println(" Movie Deleted !");
				System.out.println(" Movie details Updated ");
				

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