package hibernateSessionDao;

import config.HibernateSessionConfig;
import model.Category;
import model.CdDiskEntity;
import model.CdPlayerEntity;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import services.CategoryService;
import services.CdDiskService;
import services.CdPlayerService;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by dmakarov on 9/21/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateSessionConfig.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CategoryDaoTest {
    private static Logger LOGGER = LoggerFactory.getLogger(CdDTrackDaoTest.class);
    Category parentCategory;
    Category childCategory1;
    Category childCategory2;
    Category childCategory3;

    Category childCategory1_1;
    Category childCategory2_1;
    Category childCategory2_2;

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Autowired
    private CategoryService categoryService;


    @Before
    public  void Initialize() {
        parentCategory = new Category();
        childCategory1 = new Category();
        childCategory2 = new Category();
        childCategory3 = new Category();
        childCategory1_1 = new Category();
        childCategory2_1 = new Category();
        childCategory2_2 = new Category();

        childCategory1.setChildCategorys(Arrays.asList(childCategory1_1));
        childCategory2.setChildCategorys(Arrays.asList(childCategory2_1, childCategory2_2));
        parentCategory.setChildCategorys(Arrays.asList(childCategory1,childCategory2,childCategory3));
    }


    @Test
    public void category_Links_shouldBeStoredCompletely () {
        categoryService.saveCategory(parentCategory);

        Category updatedCategory = categoryService.getFullWithlinkedChilds(parentCategory.getId());
        assertEquals(parentCategory.getId(), updatedCategory.getId());
        assertEquals(3, parentCategory.getChildCategorys().size());

        for (Category category : updatedCategory.getChildCategorys()) {
            LOGGER.info("CHILD CATEGORY: " + category.getId() + " _ " + category.getParentCategory() + " - " + category.getChildCategorys());
        }
    }


}
