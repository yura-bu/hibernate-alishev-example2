package ru.bulanov;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.bulanov.models.Item;
import ru.bulanov.models.Person;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args ) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);
        try(SessionFactory sessionFactory = configuration.buildSessionFactory();
                Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            Person person = session.get(Person.class, 1);
            System.out.println(person.getItems());
            Item item = session.get(Item.class, 4);
            System.out.println("___________________");
            System.out.println(item + " " + item.getOwner());

            session.getTransaction().commit();
        }

    }
}
