package Service.imp;

import Entity.Account;
import Repository.imp.SessionFactorySingleton;
import Repository.imp.AccountRepository;
import Service.UserService;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Random;
@Getter
@Setter
public class AccountService implements UserService<Account>
{
    private String name;
    AccountRepository accountRepository = new AccountRepository();
    SessionFactory sessionFactory = SessionFactorySingleton.getInstance();


    @Override
    public Account add(Account account) {
        Random random = new Random();
       // int id = random.ints(4, 1000, 1999).findFirst().getAsInt();
        var ids=  Math.abs(account.hashCode() % 1000000);
        account.setUserId(ids);
        System.out.println(ids);
        try (var session = sessionFactory.getCurrentSession()) {
            var t = session.getTransaction();
            try {
                t.begin();
                accountRepository.add(account);
                t.commit();
            } catch (Exception e) {
                e.printStackTrace();
                t.rollback();
            }
        }
        return account;
    }

    @Override
    public void modify(Account account) {
        try (var session = sessionFactory.getCurrentSession()) {
            var t = session.getTransaction();
            try {

                accountRepository.modify(account);
                t.commit();
            } catch (Exception e) {
                t.rollback();
            }
        }
    }

    @Override
    public List<Account> findAll() {
        List<Account> list =null;
         try (var session = sessionFactory.getCurrentSession()) {
            var t = session.getTransaction();
            try {

                list =accountRepository.findAll();
                t.commit();
            } catch (Exception e) {
                t.rollback();
            }
        }
         return list;
    }

    @Override
    public Account findById(Integer id) {
        Account account = null;
        try (var session = sessionFactory.getCurrentSession()) {
            var t = session.getTransaction();
            try {
                 account=accountRepository.findById(id);
                t.commit();
            } catch (Exception e) {
                t.rollback();
            }
        }
        return account;
    }
    public Account findByUserId(Integer id) {
        Account account = null;
        try (var session = sessionFactory.getCurrentSession()) {
            var t = session.getTransaction();
            try {
                account=accountRepository.findByUserId(id);
                t.commit();
            } catch (Exception e) {
                t.rollback();
            }
        }
        return account;
    }
    public void changePassword(Integer newPass){
        try (var session = sessionFactory.getCurrentSession()) {
            var t = session.getTransaction();
            try {
                accountRepository.ChangePassword(newPass,name);
                t.commit();
            } catch (Exception e) {
                t.rollback();
            }
        }
    }
    public Account findByUserName(String name) {
        Account account = null;
        try (var session = sessionFactory.getCurrentSession()) {
            var t = session.getTransaction();
            try {
                account=accountRepository.findByUserName(name);
                t.commit();
            } catch (Exception e) {
                t.rollback();
            }
        }
        return account;
    }

}
