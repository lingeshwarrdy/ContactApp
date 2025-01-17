package com.edubridge.one2one;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.edubridge.one2one.Utils.HibernateUtils;
import com.edubridge.one2one.model.Course;
import com.edubridge.one2one.model.Student;

public class SaveStudent {

	public static void main(String[] args) {

		Course course = new Course();
		course.setCourseName("JFS");
		course.setCourseDuration(250);
		course.setCourseFee(2000.0);

		Student student = new Student();
		student.setStudentName("Raaj");
		student.setStudentEmail("raj@gmail.com");
		student.setStudentMobile(8309550152L);
		student.setStudentCourse(course);

		Transaction tx = null;

		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			session.persist(student);
			tx = session.beginTransaction();
			tx.commit();
			System.out.println("New movie is added");
		} catch (Exception e) {
			// tx.rollback();
			e.printStackTrace();
		}
	}

}
