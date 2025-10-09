package PosSystem.dao;

import PosSystem.model.Category;
import java.util.List;

public interface CategoryDao {

    public List<Category> getCategories();
    public boolean addCategory(Category c);
    
}
