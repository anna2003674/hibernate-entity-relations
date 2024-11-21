package org.example.hibernate_core.crud_operation;

import org.example.hibernate_core.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreatePerson {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            Person person1 = new Person("Masha", 30);
            Person person2 = new Person("Dasha", 40);
            Person person3 = new Person("Anna", 50);
            session.save(person1);
            session.save(person2);
            session.save(person3);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
