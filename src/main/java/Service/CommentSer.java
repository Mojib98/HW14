package Service;

import Entity.BasicClass;
import Entity.Tweet;

import java.util.List;

public interface CommentSer<T extends BasicClass>{
    T addComment(T t);
    T deleteComment(T t);
    T showComment(T t);
    List<T> findAll(Integer id);
    List<T> findAll();
    T reply(T t);
    T showReply(Integer id);
    T showReply();
    Tweet findTweet(Integer id);

}
