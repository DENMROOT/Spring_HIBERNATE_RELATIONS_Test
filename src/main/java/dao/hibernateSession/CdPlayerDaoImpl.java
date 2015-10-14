package dao.hibernateSession;

import dao.CdPlayerDao;
import model.CdPlayerEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by dmakarov on 9/24/2015.
 */
@Repository
public class CdPlayerDaoImpl extends BaseDaoImpl<CdPlayerEntity> implements CdPlayerDao {
    @Autowired
    private SessionFactory sessionFactory;

    public CdPlayerDaoImpl() {
    }

    private Session currentSession(){
        return sessionFactory.getCurrentSession();
    }
}