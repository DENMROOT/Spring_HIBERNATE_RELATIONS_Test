package services;

import model.CdTrackEntity;

/**
 * Created by dmakarov on 9/24/2015.
 */
public interface CdTrackService {
    void saveCdTrack(CdTrackEntity cdTrackEntity);

    CdTrackEntity getCdTrack(long id);

    void updateCdDick(CdTrackEntity cdTrackEntity);

    void deleteCdTrack(CdTrackEntity cdTrackEntity);
}
