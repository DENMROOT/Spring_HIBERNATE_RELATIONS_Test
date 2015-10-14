package services.impl;

import dao.CdDiskDao;
import model.CdDiskEntity;
import model.CdTrackEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import services.CdDiskService;

import java.util.List;

/**
 * Created by dmakarov on 9/24/2015.
 */
@Component
@Transactional
public class CdDiskServiceImpl implements CdDiskService {
    @Autowired
    private CdDiskDao cdDiskDao;

    public void saveCdDisk(CdDiskEntity cdDiskEntity) {
        cdDiskDao.save(cdDiskEntity);
    }

    public CdDiskEntity getCdDisk(long id) {
        return cdDiskDao.get(id);
    }

    public CdDiskEntity getFullCdDisk(long id) {
        return cdDiskDao.getFull(id);
    }

    public void updateCdDick(CdDiskEntity cdDiskEntity) {
        cdDiskDao.update(cdDiskEntity);
    }

    public void deleteCdDisk(CdDiskEntity cdDiskEntity) {
        cdDiskDao.delete(cdDiskEntity);
    }

    public void addTrackList(CdDiskEntity cdDiskEntity, List<CdTrackEntity> tracks) {
        cdDiskEntity.setTracks(tracks);
        cdDiskDao.update(cdDiskEntity);
    }
}
