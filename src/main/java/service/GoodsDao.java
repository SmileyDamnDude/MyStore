package service;

import entities.Category;
import entities.Goods;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.ArrayList;

@Stateless
public class GoodsDao
{
    @PersistenceContext(unitName = "Store")
    private EntityManager em;

    public int saveGoods(Goods goods)throws SQLException {
        Query query = em.createNativeQuery("{call saveGoods(?,?,?,?,?)}",
                Goods.class)
                .setParameter(1, goods.getCategoryId())
                .setParameter(2, goods.getTitle())
                .setParameter(3, goods.getPrice())
                .setParameter(4, goods.getCount())
                .setParameter(5, goods.getDescription())
                ;
        return query.executeUpdate();
    }

    public int updateGoods(Goods goods)throws SQLException {
        Query query = em.createNativeQuery("{call updateGoods(?,?,?,?,?,?)}",
                Goods.class)
                .setParameter(1, goods.getId())
                .setParameter(2, goods.getCategoryId())
                .setParameter(3, goods.getTitle())
                .setParameter(4, goods.getPrice())
                .setParameter(5, goods.getCount())
                .setParameter(6, goods.getDescription())
                ;
        return query.executeUpdate();
    }

    public int delete(int id)throws SQLException {
        Query query = em.createNativeQuery("{call deleteGoods(?)}",
                Goods.class)
                .setParameter(1, id)
                ;
        return query.executeUpdate();
    }

    public ArrayList<Goods> findById(int number) {
        Query query = em.createNativeQuery("{call findGoodsById(?)}", Goods.class)
                .setParameter(1, number)
                ;
        return new ArrayList<Goods>(query.getResultList());
    }

    public ArrayList<Goods> findByTitle(String title) {
        Query query = em.createNativeQuery("{call findGoodsByTitle(?)}", Goods.class)
                .setParameter(1, title)
                ;
        return new ArrayList<Goods>(query.getResultList());
    }

    public ArrayList<Goods> findAll() {
        Query query = em.createNativeQuery("{call findAllGoods()}", Goods.class);
        return new ArrayList<Goods>(query.getResultList());
    }

}
