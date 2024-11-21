package org.example.one_to_many;

import org.example.one_to_many.model.Item;
import org.example.one_to_many.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;

public class App4 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
            .addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            Person person = new Person("Maria", 30);
            Item newItem = new Item("IPad 10", person);
            person.setItems(new ArrayList<>(Collections.singletonList(newItem)));
            session.save(person);
            session.save(newItem);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
