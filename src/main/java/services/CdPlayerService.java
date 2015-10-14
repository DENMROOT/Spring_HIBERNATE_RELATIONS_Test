package services;

import model.CdPlayerEntity;

/**
 * Created by dmakarov on 9/24/2015.
 */
public interface CdPlayerService {
    void saveCdPlayer(CdPlayerEntity cdPlayerEntity);

    CdPlayerEntity getCdPlayer(long id);

    void updateCdDick(CdPlayerEntity cdPlayerEntity);

    void deleteCdPlayer(CdPlayerEntity cdPlayerEntity);
}
