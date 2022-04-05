package Repository;

import Entity.Account;
import Repository.imp.SessionFactorySingleton;
import org.hibernate.SessionFactory;

public class LoginRepository {
  private final   SessionFactory sessionFactory = SessionFactorySingleton.getInstance();

    public Account checking(String name, Integer passcode) {
        var session = sessionFactory.getCurrentSession();
        String hql = " from Entity.Account where  " +
                "userName = :name and passCode =: passcode";
        var query = session.createQuery(hql, Account.class);
        query.setParameter("name", name);
        query.setParameter("passcode", passcode);
        Account result = query.uniqueResult();
        return result;
    }
}
