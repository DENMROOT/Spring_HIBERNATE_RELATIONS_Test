package dao.hibernateSession;

import dao.CdTrackDao;
import model.CdTrackEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by dmakarov on 9/24/2015.
 */
@Repository
public class CdTrackDaoImpl  extends BaseDaoImpl<CdTrackEntity> implements CdTrackDao {
    @Autowired
    private SessionFactory sessionFactory;

    public CdTrackDaoImpl() {
    }

    private Session currentSession(){
        return sessionFactory.getCurrentSession();
    }
}
