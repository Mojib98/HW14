package Service.imp;

import Entity.Account;
import Entity.Tweet;
import Repository.imp.AccountRepository;
import Repository.imp.SessionFactorySingleton;
import Repository.imp.TweetRepository;
import Service.TweetServiceInterface;
import org.hibernate.SessionFactory;

import java.util.List;

public class TweetService implements TweetServiceInterface<Tweet> {
    private Account account;
    SessionFactory sessionFactory = SessionFactorySingleton.getInstance();
    TweetRepository tweetRepository = new TweetRepository();



    private String name;
    @Override
    public Tweet add(Tweet tweet) {
      //  tweet.setAccount(this.account);
        try (var session = sessionFactory.getCurrentSession()) {
            var t = session.getTransaction();
            try {
                t.begin();
                tweetRepository.add(tweet);
                t.commit();
            } catch (Exception e) {
                e.printStackTrace();
                t.rollback();
            }
        }

        return tweet;
    }

    @Override
    public void modify(Tweet tweet) {
        try (var session = sessionFactory.getCurrentSession()) {
            var t = session.getTransaction();
            t.begin();
            try {
                tweetRepository.modify(tweet);
                t.commit();
            } catch (Exception e) {
                e.printStackTrace();
                t.rollback();
            }
        }

    }

    @Override
    public List<Tweet> findAll() {
        List<Tweet> list= null;
        try (var session = sessionFactory.getCurrentSession()) {
            var t = session.getTransaction();
            t.begin();
            try {
            list=  tweetRepository.findAll();
                t.commit();
            } catch (Exception e) {
                e.printStackTrace();
                t.rollback();
            }
        }
        return list;
    }

    @Override
    public List<Tweet> findAllMyTweet(Account account) {
        List<Tweet> list= null;
        try (var session = sessionFactory.getCurrentSession()) {
            var t = session.getTransaction();
            t.begin();
            try {
                list=  tweetRepository.findAllMyTweet(account);
                t.commit();
            } catch (Exception e) {
                e.printStackTrace();
                t.rollback();
            }
        }
        return list;
    }

    @Override
    public void like(Integer id) {
        try (var session = sessionFactory.getCurrentSession()) {
            var t = session.getTransaction();
            t.begin();
            try {
               tweetRepository.like(id);
                t.commit();
            } catch (Exception e) {
                e.printStackTrace();
                t.rollback();
            }
        }

    }

    @Override
    public void dislike(Integer id) {
        try (var session = sessionFactory.getCurrentSession()) {
            var t = session.getTransaction();
            t.begin();
            try {
                tweetRepository.dislike(id);
                t.commit();
            } catch (Exception e) {
                e.printStackTrace();
                t.rollback();
            }
        }
    }

    @Override
    public Tweet findById(Integer id) {
        Tweet tweet = null;
        try (var session = sessionFactory.getCurrentSession()) {
            var t = session.getTransaction();
            t.begin();
            try {
               tweet= tweetRepository.findById(id);
                t.commit();
            } catch (Exception e) {
                e.printStackTrace();
                t.rollback();
            }
        }
        return tweet;
    }

    @Override
    public Tweet findByUserName() {
        return null;
    }

    @Override
    public void setAccount(Account account) {
    this.account=account;
    }

}
