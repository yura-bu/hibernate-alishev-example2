package ru.bulanov;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.bulanov.models.Item;
import ru.bulanov.models.Passport;
import ru.bulanov.models.Person;

import java.util.List;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args ) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(Passport.class);
        try(SessionFactory sessionFactory = configuration.buildSessionFactory();
                Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            Passport passport = session.get(Passport.class, 4);
            System.out.println(passport);
            session.getTransaction().commit();
        }

    }
}
