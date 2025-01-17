package com.edubridge.App1.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.edubridge.App1.Model.Movie;
import com.edubridge.App1.Utils.HibernateUtils;

public class UpdateMoviebyName {
	public static void main(String[] args) {
		
		Transaction tx=null;

		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			tx =session.beginTransaction();
			String hql =" update Movie set title =:title where hero=:hero";
			
			Query query=session.createQuery(hql);
			
			query.setParameter("title", "XTZ");
			query.setParameter("hero", "Ramcharan");
			int status = query.executeUpdate();
			if(status >=1) {
				System.out.println("Updated");
				tx.commit();
			}
			else {
				System.out.println("Failed");
			}
			
		} catch (Exception e2) {
			
			

			e2.printStackTrace();

		}

		/*
		 * finally { session.close(); }
		 */
	}
}
