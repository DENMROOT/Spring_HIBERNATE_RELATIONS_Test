package services.impl;

import dao.CategoryDao;
import dao.CdDiskDao;
import model.Category;
import model.CdDiskEntity;
import model.CdTrackEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import services.CategoryService;
import services.CdDiskService;

import java.util.List;

/**
 * Created by dmakarov on 9/24/2015.
 */
@Component
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    public void saveCategory(Category category) {
        categoryDao.save(category);
    }

    public Category getCategory(long id) {
        return categoryDao.get(id);
    }

    public Category getFullCategory(long id) {
        return categoryDao.getFull(id);
    }

    public Category getFullWithlinkedChilds(long id) {
        return categoryDao.getFullWithlinkedChilds(id);
    }

    public void updateCategory(Category category) {
        categoryDao.update(category);
    }

    public void deleteCategory(Category category) {
        categoryDao.delete(category);
    }

}
