package Repository;

import Entity.Account;
import Entity.Tweet;

import java.util.List;

public interface TweetRep<T extends Tweet> {
    void add(T t);

    void modify(T t);

    List<T> findAll();

    List<T> findAllMyTweet(Account account);

    void like(Integer id);

    void dislike(Integer id);

    T findById(Integer id);

    List<Tweet> findByUserName(String name);
}
