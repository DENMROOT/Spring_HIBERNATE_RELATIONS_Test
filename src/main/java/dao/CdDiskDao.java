package dao;

import model.CdDiskEntity;

/**
 * Created by dmakarov on 9/24/2015.
 */
public interface CdDiskDao extends BaseDao<CdDiskEntity, Long>{
    CdDiskEntity getFull(long id);
}
