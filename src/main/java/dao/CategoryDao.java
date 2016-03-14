package dao;

import model.Category;
import model.CdDiskEntity;

/**
 * Created by dmakarov on 9/24/2015.
 */
public interface CategoryDao extends BaseDao<Category, Long>{
    Category getFull(long id);
    Category getFullWithlinkedChilds(long id);
}
