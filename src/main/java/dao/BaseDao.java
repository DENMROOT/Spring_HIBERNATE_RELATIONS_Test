package dao;

import java.io.Serializable;

/**
 * Created by dmakarov on 10/1/2015.
 */
public interface BaseDao <T, ID extends Serializable> {
    void save(T entity);

    T get(ID id);

    void update(T entity);

    void delete(T entity);
}
