package Repository.imp;

import Entity.Account;
import Entity.BasicClass;
import Entity.Tweet;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactorySingleton {

    private SessionFactorySingleton() {}

    private static class LazyHolder {
        static SessionFactory INSTANCE;

        static {
            var registry = new StandardServiceRegistryBuilder()
                    .configure() // goes and fetches configuration from hibernate.cfg.xml
                    .build();

            // registry is useful for creating SessionFactory
            // SessionFactory is a heavyweight object.
            // SessionFactory is thread safe.
            // SessionFactory is immutable.
            INSTANCE = new MetadataSources(registry)
                    .addAnnotatedClass(Account.class)
                  //  .addAnnotatedClass(Tweet.class)
                    .addAnnotatedClass(BasicClass.class)
        /*            .addAnnotatedClass(Person.class)
                    .addAnnotatedClass(BaseClass.class)
                    .addAnnotatedClass(Employee.class)
                    .addAnnotatedClass(Professor.class)
                    .addAnnotatedClass(Course.class)
                    .addAnnotatedClass(Student.class)
                    .addAnnotatedClass(BaseCourse.class)
                    .addAnnotatedClass(SectionCourse.class)*/
                    .buildMetadata()
                    .buildSessionFactory();
        }
    }

    public static SessionFactory getInstance() {
        return LazyHolder.INSTANCE;
    }
}
