package Service.imp;

import Entity.Account;
import Entity.Tweet;
import Repository.imp.AccountRepository;
import Repository.imp.SessionFactorySingleton;
import Service.TweetServiceInterface;
import org.hibernate.SessionFactory;

import java.util.List;

public class TweetService implements TweetServiceInterface<Tweet> {
    private Account account;
    SessionFactory sessionFactory = SessionFactorySingleton.getInstance();



    private String name;
    @Override
    public Tweet add(Tweet tweet) {
        tweet.setAccount(this.account);
        try (var session = sessionFactory.getCurrentSession()) {
            var t = session.getTransaction();
            t.begin();
            try {
                //accountRepository.add(account);
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

    @Override
    public void setAccount(Account account) {
    this.account=account;
    }

}
