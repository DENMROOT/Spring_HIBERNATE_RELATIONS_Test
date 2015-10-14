package dao.hibernateSession;

import dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;

/**
 * Created by dmakarov on 9/24/2015.
 */
@Repository
public class BaseDaoImpl<T> implements BaseDao <T, Long> {
    @Autowired
    private SessionFactory sessionFactory;

    public BaseDaoImpl() {
    }

    private Session currentSession(){
        return sessionFactory.getCurrentSession();
    }

    public void save(T entity) {
        currentSession().save(entity);
    }

    public T get(Long id) {
        return (T) currentSession().get((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0], id);
    }

    public void update(T entity) {
        currentSession().merge(entity);
    }

    public void delete(T entity) {
        currentSession().delete(entity);

    }
}
