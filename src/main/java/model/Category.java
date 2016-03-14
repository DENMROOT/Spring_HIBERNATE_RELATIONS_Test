package model;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.util.List;

/**
 * Created by DENM on 14.03.2016.
 */
@Entity
@Table(name="CATEGORY")
public class Category {
    @Id
    @GeneratedValue()
    private long id;

    @OneToOne
    private Category parentCategory;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "CATEGORY_LINK")
    private List<Category> childCategorys;

    public long getId() {
        return id;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public List<Category> getChildCategorys() {
        return childCategorys;
    }

    public void setChildCategorys(List<Category> childCategorys) {
        for (Category childCategory : childCategorys) {
            childCategory.setParentCategory(this);
        }
        this.childCategorys = childCategorys;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equal(parentCategory, category.parentCategory) &&
                Objects.equal(childCategorys, category.childCategorys);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(parentCategory, childCategorys);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("parentCategory", parentCategory)
                .toString();
    }
}
