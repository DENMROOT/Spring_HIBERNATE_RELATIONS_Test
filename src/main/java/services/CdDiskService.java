package services;

import model.CdDiskEntity;
import model.CdTrackEntity;

import java.util.List;

/**
 * Created by dmakarov on 9/24/2015.
 */
public interface CdDiskService {
    void saveCdDisk(CdDiskEntity cdDiskEntity);

    CdDiskEntity getCdDisk(long id);

    CdDiskEntity getFullCdDisk(long id);

    void updateCdDick(CdDiskEntity cdDiskEntity);

    void deleteCdDisk(CdDiskEntity cdDiskEntity);

    void addTrackList (CdDiskEntity cdDiskEntity, List<CdTrackEntity> tracks);
}
