package com.edubridge.App1.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.edubridge.App1.Model.Movie;
import com.edubridge.App1.Utils.HibernateUtils;

public class deleteMoviebyName {
	public static void main(String[] args) {
		
		String name="RamCharan";
		
		Transaction tx=null;

		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			
			tx =session.beginTransaction();

			String hql =" delete from  Movie where hero=:name";
			
			Query query=session.createQuery(hql);
			query.setParameter("name", name);
			int status = query.executeUpdate();
			if(status >=1) {
				System.out.println("deleted");
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
