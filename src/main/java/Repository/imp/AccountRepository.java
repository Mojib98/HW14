package Repository.imp;

import Entity.Account;
import Repository.Repository;
import org.hibernate.SessionFactory;


import java.util.List;

public class AccountRepository implements Repository<Account> {
    SessionFactory sessionFactory = SessionFactorySingleton.getInstance();
    @Override
    public void add(Account account) {
        var t = sessionFactory.getCurrentSession();
        t.save(account);
    }

    @Override
    public void modify(Account account) {
        var t = sessionFactory.getCurrentSession();
        t.update(account);
    }

    @Override
    public List<Account> findAll() {
        List<Account> list =null;
        var t = sessionFactory.getCurrentSession();
        String hql = "from Entity.Account";
        var q = t.createQuery(hql,Account.class);
        list = q.getResultList();
        return list;
    }

    @Override
    public Account findById(Integer id) {
        var t = sessionFactory.getCurrentSession();
        String hql = "from Entity.Account where " +
                "id =:id";
        var q = t.createQuery(hql,Account.class);
        q.setParameter("id",id);
        return q.getSingleResult();
    }

    @Override
    public Account findByUserId(Integer id) {
        var t = sessionFactory.getCurrentSession();
        String hql = "from Entity.Account where " +
                "userId =:id";
        var q = t.createQuery(hql,Account.class);
        q.setParameter("id",id);
        return q.getSingleResult();
    }
}
