package org.example.many_to_many;

import org.example.many_to_many.model.Actor;
import org.example.many_to_many.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App4 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Actor.class)
            .addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Actor actor = session.get(Actor.class, 2);
            System.out.println(actor.getMovies());
            Movie movieToRemove = actor.getMovies().get(0);
            actor.getMovies().remove(0);
            movieToRemove.getActors().remove(actor);
            session.getTransaction().commit();
        }
    }
}
