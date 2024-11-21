package org.example.hibernate_core.hql_request;

import org.example.hibernate_core.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class GetAllPersonsLike {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            List<Person> people = session.createQuery("FROM Person WHERE name LIKE 'D%'").getResultList();
            for (Person person : people) {
                System.out.println(person);
            }
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
