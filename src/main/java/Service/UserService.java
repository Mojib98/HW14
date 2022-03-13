package Service;

import Entity.BasicClass;

import java.util.List;

public interface UserService <T extends BasicClass> {
    T add(T t);
    void modify(T t);
    List<T> findAll();
    T findById(Integer id);

}
