package services.impl;

import dao.CdPlayerDao;
import model.CdPlayerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import services.CdPlayerService;

/**
 * Created by dmakarov on 9/24/2015.
 */
@Component
@Transactional
public class CdPlayerServiceImpl implements CdPlayerService {
    @Autowired
    private CdPlayerDao CdPlayerDao;

    public void saveCdPlayer(CdPlayerEntity cdPlayerEntity) {
        CdPlayerDao.save(cdPlayerEntity);
    }

    public CdPlayerEntity getCdPlayer(long id) {
        return CdPlayerDao.get(id);
    }

    public void updateCdDick(CdPlayerEntity cdPlayerEntity) {
        CdPlayerDao.update(cdPlayerEntity);
    }

    public void deleteCdPlayer(CdPlayerEntity cdPlayerEntity) {
        CdPlayerDao.delete(cdPlayerEntity);
    }
}
