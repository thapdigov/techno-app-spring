package az.perfect.jdbs.dao.inter;

import az.perfect.jdbs.entity.Category;


import java.util.List;

public interface CategoryDaoInter {
    public void insert(Category c);

    public void update(Category c);

    public void Delete(int id);

    Category getcategory(int id);

    List<Category> getAllCategorys();

    public int count();


}
