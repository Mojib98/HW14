package Service;

import Entity.Account;
import Repository.LoginRepository;
import Repository.imp.SessionFactorySingleton;
import org.hibernate.SessionFactory;

public class LoginService {
    SessionFactory sessionFactory = SessionFactorySingleton.getInstance();
        LoginRepository loginRepository = new LoginRepository();
    public boolean checking(String name,Integer passCode){
        Account account=null;
        try (var session = sessionFactory.getCurrentSession()) {
            var t = session.getTransaction();
            try {
                t.begin();
                 account = loginRepository.checking(name,passCode);
                        t.commit();
            } catch (Exception e) {
                e.printStackTrace();
                t.rollback();
            }
        }
        if (account !=null){
            return true;
        }else {
            return false;
        }

    }
}
