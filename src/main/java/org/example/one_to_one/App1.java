package org.example.one_to_one;

import org.example.one_to_one.model.Passport;
import org.example.one_to_one.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App1 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
            .addAnnotatedClass(Person.class).addAnnotatedClass(Passport.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            Person person = new Person("Test person", 21);
            Passport passport = new Passport(12345);
            person.setPassport(passport);
            session.save(person);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
