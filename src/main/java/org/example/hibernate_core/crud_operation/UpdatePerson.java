package org.example.hibernate_core.crud_operation;

import org.example.hibernate_core.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdatePerson {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            Person person = session.get(Person.class, 1);
            person.setName("Alex");
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
