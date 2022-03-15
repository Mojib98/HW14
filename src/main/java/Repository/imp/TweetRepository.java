package Repository.imp;

import Entity.Account;
import Entity.Tweet;
import Repository.TweetRep;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;

import java.util.List;

import static com.sun.tools.attach.VirtualMachine.list;

public class TweetRepository implements TweetRep<Tweet> {
    SessionFactory sessionFactory;

    public TweetRepository() {
        sessionFactory = SessionFactorySingleton.getInstance();
    }

    @Override
    public void add(Tweet tweet) {
        var session = sessionFactory.getCurrentSession();
        session.save(tweet);
    }

    @Override
    public void modify(Tweet tweet) {
        var session = sessionFactory.getCurrentSession();
        session.update(tweet);

    }

    @Override
    public List<Tweet> findAll() {
        var session = sessionFactory.getCurrentSession();
        String hql="from Entity.Tweet";
        var query=session.createQuery(hql,Tweet.class);
        return query.list();
    }

    @Override
    public List<Tweet> findAllMyTweet(Account account) {
        List<Tweet> list = null;
        var session = sessionFactory.getCurrentSession();
        String hql="from Entity.Tweet " +
                "where account.userName =:id";
        var query=session.createQuery(hql,Tweet.class);
        query.setParameter("id",account.getUserName());
        list =query.getResultList();
        return list;
    }

    @Override
    public void like(Integer id) {
        var session = sessionFactory.getCurrentSession();
        var d = session.find(Tweet.class,id);
        System.out.println(d);
        Integer like = d.getLikes()+1;
        String hql="update Entity.Tweet set likes = :likes " +
                "where id =:id";
        var query=session.createQuery(hql);
        query.setParameter("id",id);
        query.setParameter("likes",like);
       var s= query.executeUpdate();
        System.out.println("do like "+s);

    }

    @Override
    public void  dislike(Integer id) {/*
        var session = sessionFactory.getCurrentSession();
        String hql="update Tweet set  dislike=dislike+1 " +
                "where id =:id";
        var query=session.createSQLQuery(hql);
        query.setParameter("id",id);*/

    }

    @Override
    public Tweet findById(Integer id) {
        Tweet tweet = null;
        var session = sessionFactory.getCurrentSession();
        String hql="from Entity.Tweet " +
                "where id =:id";
        var query=session.createQuery(hql,Tweet.class);
        query.setParameter("id",id);
        tweet = query.uniqueResult();
        return tweet;
    }

    @Override
    public List<Tweet> findByUserName(String name) {
        List<Tweet> tweet = null;
        var session = sessionFactory.getCurrentSession();
        String hql="from Entity.Tweet  " +
                "where account.userName =:name";
        var query=session.createQuery(hql,Tweet.class);
        query.setParameter("name",name);
        tweet = query.list();
        return tweet;
    }
}
