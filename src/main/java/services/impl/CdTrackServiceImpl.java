package services.impl;

import dao.CdTrackDao;
import model.CdTrackEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import services.CdTrackService;

/**
 * Created by dmakarov on 9/24/2015.
 */
@Component
@Transactional
public class CdTrackServiceImpl implements CdTrackService {
    @Autowired
    private CdTrackDao CdTrackDao;

    public void saveCdTrack(CdTrackEntity CdTrackEntity) {
        CdTrackDao.save(CdTrackEntity);
    }

    public CdTrackEntity getCdTrack(long id) {
        return CdTrackDao.get(id);
    }

    public void updateCdDick(CdTrackEntity CdTrackEntity) {
        CdTrackDao.update(CdTrackEntity);
    }

    public void deleteCdTrack(CdTrackEntity CdTrackEntity) {
        CdTrackDao.delete(CdTrackEntity);
    }
}
