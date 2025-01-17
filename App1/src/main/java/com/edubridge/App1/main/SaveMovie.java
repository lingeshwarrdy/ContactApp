package com.edubridge.App1.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.edubridge.App1.Model.Movie;
import com.edubridge.App1.Utils.HibernateUtils;

public class SaveMovie {
    public static void main(String[] args) {
        Movie movie = new Movie();
        movie.setTitle("Abc");
        movie.setDirector("Raja");
        movie.setHero("RamCharan");

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {
            session.persist(movie); // INSERT OPERATION
            tx.commit();
            System.out.println("New movie is added");
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}

/*

package com.edubridge.App1.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.edubridge.App1.Model.Movie;
import com.edubridge.App1.Utils.HibernateUtils;

public class SaveMovie {
    public static void main(String[] args) {
        Movie movie = new Movie();
        movie.setTitle("SALLAR");
        movie.setDirector("Prashanth Neel");
        movie.setHero("Prabhas");

        
        Transaction tx = null

        try(Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.persist(movie); // INSERT OPERATION
            tx.commit();
            System.out.println("New movie is added");
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }
}

 =>with out using finally block  to close the session  we need to use try with resources
 => Inside try we need to create session object
 
*/