package Repository.imp;

import Entity.Comment;
import Entity.Tweet;
import Repository.CommentRep;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class CommentRepository implements CommentRep<Comment> {
    SessionFactory sessionFactory = SessionFactorySingleton.getInstance();


    @Override
    public Comment addComment(Comment comment) {
        var session = sessionFactory.getCurrentSession();
        session.save(comment);
        return comment;
    }

    @Override
    public Comment deleteComment(Comment comment) {
        var session = sessionFactory.getCurrentSession();
        session.remove(comment);
        return comment;
    }

    @Override
    public Comment showComment(Comment comment) {
        var session = sessionFactory.getCurrentSession();
        session.find(comment.getClass(),comment.getId());
        return comment;
    }

    @Override
    public List<Comment> findAll(Integer id) {
        var session = sessionFactory.getCurrentSession();
        String hql="from Entity.Comment where " +
                "tweet.id =:id";
        var query = session.createQuery(hql,Comment.class);
        query.setParameter("id",id);
        return query.list();
    }

    @Override
    public List<Comment> findAll() {
        var session = sessionFactory.getCurrentSession();
        String hql="from Entity.Comment ";
        var query = session.createQuery(hql,Comment.class);
        return query.list();
    }

    @Override
    public Comment reply(Comment comment) {
        return null;
    }


    public Comment reply(Comment comment,Comment comment1) {
        var session = sessionFactory.getCurrentSession();
        session.save(comment);
        comment1.addReply(comment);
        session.update(comment1);
        return comment;
    }

    @Override
    public Comment showReply(Integer id) {
        var session = sessionFactory.getCurrentSession();
        String hql="from Entity.Comment where " +
                "id =:id";
        var query = session.createQuery(hql,Comment.class);
        query.setParameter("id",id);
        return query.uniqueResult();
    }

    @Override
    public Comment showReply() {
        return null;
    }

    @Override
    public Tweet findTweet(Integer id) {
        return null;
    }
    public Comment findById(Integer id){
        var session = sessionFactory.getCurrentSession();
        return session.find(Comment.class,id);
    }
}
