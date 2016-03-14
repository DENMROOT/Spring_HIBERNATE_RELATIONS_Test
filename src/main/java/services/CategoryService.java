package services;

import model.Category;
import model.CdDiskEntity;
import model.CdTrackEntity;

import java.util.List;

/**
 * Created by dmakarov on 9/24/2015.
 */
public interface CategoryService {
    void saveCategory(Category category);

    Category getCategory(long id);

    Category getFullCategory(long id);

    Category getFullWithlinkedChilds(long id);

    void updateCategory(Category category);

    void deleteCategory(Category category);

}
