package Repository;

import Entity.Account;
import Entity.BasicClass;

import java.util.Base64;
import java.util.List;

public interface Repository<T extends BasicClass> {
    void add(T t);

    void modify(T t);

    List<T> findAll();

    T findById(Integer id);

    Account findByUserId(Integer id);

    Account findByUserName(String name);
    void ChangePassword(Integer newPassCode, String name);
    void unfollow(Account account1, Account account2);
}
