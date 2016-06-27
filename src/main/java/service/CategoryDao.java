package service;

import entities.Category;
import entities.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CategoryDao
{
    @PersistenceContext(unitName = "Store")
    private EntityManager em;

    public int saveCategory(Category category)throws SQLException {
        Query query = em.createNativeQuery("{call saveCategory(?,?)}",
                Category.class)
                .setParameter(1, category.getTitle())
                .setParameter(2, category.getDescription())
                ;
        return query.executeUpdate();
    }

    public int delete(int id)throws SQLException {
        Query query = em.createNativeQuery("{call deleteCategory(?)}",
                Category.class)
                .setParameter(1, id)
                ;
        return query.executeUpdate();
    }

    public ArrayList<Category> findById(int number) {
        Query query = em.createNativeQuery("{call findCategoryById(?)}", Category.class)
                .setParameter(1, number)
                ;
        return new ArrayList<Category>(query.getResultList());
    }

    public ArrayList<Category> findByTitle(String title) {
        Query query = em.createNativeQuery("{call findCategoryByTitle(?)}", Category.class)
                .setParameter(1, title)
                ;
        return new ArrayList<Category>(query.getResultList());
    }

    public ArrayList<Category> findAll() {
        Query query = em.createNativeQuery("{call findAllCategories()}", Category.class);
        return new ArrayList<Category>(query.getResultList());
    }

}
