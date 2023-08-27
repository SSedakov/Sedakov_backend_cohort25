package events.repositories;

import java.util.List;

public interface CrudRepository <T>{

    T findById(int id);
    List<T> findAll();
    void save(T model);
    void update(T model);
    void deleteById(int id);
}
