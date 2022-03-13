package Service;

import Entity.Account;
import Entity.Tweet;

import java.util.List;

public interface TweetServiceInterface<T extends Tweet> {
    T add(T t);
    void modify(T t);
    List<T> findAll();
    List<T> findAllMyTweet(Account account);
    void like(Integer id);
    void dislike(Integer id);
    T findById(Integer id);
    T findByUserName();
    void setAccount(Account account);

}
