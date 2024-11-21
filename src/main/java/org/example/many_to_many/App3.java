package org.example.many_to_many;

import org.example.many_to_many.model.Actor;
import org.example.many_to_many.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;

public class App3 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Actor.class)
            .addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Movie movie = new Movie("Reservoir Dogs", 1992);
            Actor actor1 = session.get(Actor.class, 1);
            movie.setActors(new ArrayList<>(Collections.singletonList(actor1)));
            actor1.getMovies().add(movie);
            session.save(movie);
            session.getTransaction().commit();
        }
    }
}
