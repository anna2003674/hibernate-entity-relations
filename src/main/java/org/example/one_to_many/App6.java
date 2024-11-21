package org.example.one_to_many;

import org.example.one_to_many.model.Item;
import org.example.one_to_many.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App6 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
            .addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            Person person = session.get(Person.class, 2);
            session.remove(person);
            // Для того, чтобы было правильное состояние Hibernate кэша
            person.getItems().forEach(i -> i.setOwner(null));
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
