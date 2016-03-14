package dao.hibernateSession;

import dao.CategoryDao;
import dao.CdDiskDao;
import model.Category;
import model.CdDiskEntity;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by dmakarov on 9/24/2015.
 */
@Repository
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao {
    @Autowired
    private SessionFactory sessionFactory;

    public CategoryDaoImpl() {
    }

    private Session currentSession(){
        return sessionFactory.getCurrentSession();
    }

    public Category getFull(long id) {
        Category category = (Category) currentSession().get(Category.class, id);
        Hibernate.initialize(category);
        Hibernate.initialize(category.getParentCategory());
        Hibernate.initialize(category.getChildCategorys());
        return  category;
    }

    public Category getFullWithlinkedChilds(long id) {
        Category category = (Category) currentSession().get(Category.class, id);
        initChilds(category);
        return  category;
    }

    private void initChilds(Category category) {
        if (category.getChildCategorys() != null) {
            for (Category category1 : category.getChildCategorys()) {
                Hibernate.initialize(category1);
                Hibernate.initialize(category1.getParentCategory());
                Hibernate.initialize(category1.getChildCategorys());
                initChilds(category1);
            }

        }
    };

}
