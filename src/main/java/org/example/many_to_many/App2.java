package org.example.many_to_many;

import org.example.many_to_many.model.Actor;
import org.example.many_to_many.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App2 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Actor.class)
            .addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Movie movie = session.get(Movie.class, 1);
            System.out.println(movie.getActors());
            session.getTransaction().commit();
        }
    }
}
