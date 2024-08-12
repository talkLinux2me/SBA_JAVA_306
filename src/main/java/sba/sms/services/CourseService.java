package sba.sms.services;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sba.sms.dao.CourseI;
import sba.sms.models.Course;
import sba.sms.utils.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jakarta.persistence.TypedQuery;

import org.hibernate.SessionFactory;

import sba.sms.dao.CourseI;
import sba.sms.models.Course;
import sba.sms.utils.HibernateUtil;

import java.util.ArrayList;
import java.util.List;


/**
 * CourseService is a concrete class. This class implements the
 * CourseI interface, overrides all abstract service methods and
 * provides implementation for each method.
 */
public class CourseService implements CourseI {
    SessionFactory factory = new Configuration().configure().buildSessionFactory();
    Session session = null;

    public void createCourse(Course course){
        Transaction transaction = null;

        try {
            // We're starting to begin a transaction but would like to make changes to our database
            session = factory.openSession();
            transaction = session.beginTransaction();

            // Save course to our database
            session.persist(course);

            // commit course/ push course to our database
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e);
        }
    }
//COURSES
    // Course -> courseId = 2, courseName = English

    // getCourseById()

    // getCourseById(1) -> Course -> courseId = 1, courseName = Math

    // getCourseById(2) -> Course -> courseId = 2, courseName = English

}


