package org.example.one_to_one;

import org.example.one_to_one.model.Passport;
import org.example.one_to_one.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App4 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
            .addAnnotatedClass(Person.class).addAnnotatedClass(Passport.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            Person person = session.get(Person.class, 1);
            session.remove(person);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
