package Service.imp;

import Entity.Comment;
import Entity.Tweet;
import Repository.imp.CommentRepository;
import Repository.imp.SessionFactorySingleton;
import Service.CommentSer;
import org.hibernate.SessionFactory;

import java.util.List;

public class CommentService implements CommentSer<Comment> {
    SessionFactory sessionFactory = SessionFactorySingleton.getInstance();
    CommentRepository commentRepository = new CommentRepository();


    @Override
    public Comment addComment(Comment comment) {
        try (var session = sessionFactory.getCurrentSession()) {
            var t = session.getTransaction();
            try {
                t.begin();
                commentRepository.addComment(comment);
                t.commit();
            } catch (Exception e) {
                e.printStackTrace();
                t.rollback();
            }
        }
        return null;
    }

    @Override
    public Comment deleteComment(Comment comment) {
        return null;
    }

    @Override
    public Comment showComment(Comment comment) {
        return null;
    }

    @Override
    public List<Comment> findAll(Integer id) {
        return null;
    }

    @Override
    public List<Comment> findAll() {
        return null;
    }

    @Override
    public Comment reply(Comment comment) {
        return null;
    }

    @Override
    public Comment showReply(Integer id) {
        return null;
    }

    @Override
    public Comment showReply() {
        return null;
    }

    @Override
    public Tweet findTweet(Integer id) {
        return null;
    }
}
