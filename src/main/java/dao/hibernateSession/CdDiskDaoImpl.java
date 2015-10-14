package dao.hibernateSession;

import dao.CdDiskDao;
import model.CdDiskEntity;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by dmakarov on 9/24/2015.
 */
@Repository
public class CdDiskDaoImpl extends BaseDaoImpl<CdDiskEntity> implements CdDiskDao{
    @Autowired
    private SessionFactory sessionFactory;

    public CdDiskDaoImpl() {
    }

    private Session currentSession(){
        return sessionFactory.getCurrentSession();
    }

    public CdDiskEntity getFull(long id) {
        CdDiskEntity cdDisk = (CdDiskEntity) currentSession().get(CdDiskEntity.class, id);
        Hibernate.initialize(cdDisk.getTracks());
        return  cdDisk;
    }

}
