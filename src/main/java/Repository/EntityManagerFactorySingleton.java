/*
package Repository;

import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {
    private EntityManagerFactorySingleton(){}
    private static class LazyHolder{
         static EntityManager INSTANCE;
         static {
             var registry = Persistence.createEntityManagerFactory("MAKTAB");
             INSTANCE = registry.createEntityManager();
         }


    }
    public static EntityManager getInstance() {
        return EntityManagerFactorySingleton.LazyHolder.INSTANCE;
    }
}
*/
