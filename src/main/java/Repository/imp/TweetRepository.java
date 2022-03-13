package Repository.imp;

import Entity.Account;
import Entity.Tweet;
import Repository.TweetRep;
import org.hibernate.SessionFactory;

import java.util.List;

public class TweetRepository implements TweetRep<Tweet> {
    SessionFactory sessionFactory = SessionFactorySingleton.getInstance();

    @Override
    public void add(Tweet tweet) {
        var session = sessionFactory.getCurrentSession();
        session.save(tweet);
    }

    @Override
    public void modify(Tweet tweet) {

    }

    @Override
    public List<Tweet> findAll() {
        return null;
    }

    @Override
    public List<Tweet> findAllMyTweet(Account account) {
        return null;
    }

    @Override
    public void like(Integer id) {

    }

    @Override
    public void dislike(Integer id) {

    }

    @Override
    public Tweet findById(Integer id) {
        return null;
    }

    @Override
    public Tweet findByUserName() {
        return null;
    }
}
