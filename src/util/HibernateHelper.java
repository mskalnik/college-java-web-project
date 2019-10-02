package util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HibernateHelper<T> {
    public static SessionFactory getFactory() {
        SessionFactory factory;
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable exception) {
            throw new ExceptionInInitializerError(exception);
        }
        return factory;
    }

    public List<T> get(String table) {
        Session session = HibernateHelper.getFactory().openSession();
        Transaction transaction = null;
        List<T> list = new ArrayList<>();


        try {
            transaction = session.beginTransaction();
            List db = session.createQuery("FROM " + table).list();
            for (Iterator iterator = db.iterator(); iterator.hasNext();) {
                T item = (T) iterator.next();
                list.add(item);
            }
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction!=null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    public Integer add(Object object) {
        Session session = HibernateHelper.getFactory().openSession();
        Transaction transaction = null;
        Integer id = null;

        try {
            transaction = session.beginTransaction();
            id = (Integer) session.save(object);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return id;
    }
}
