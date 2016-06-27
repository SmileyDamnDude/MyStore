package service;

import entities.Category;
import entities.Goods;
import entities.Order;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.ArrayList;

@Stateless
public class OrderDao
{
    @PersistenceContext(unitName = "Store")
    private EntityManager em;

    public int saveOrder(Order order)throws SQLException {
        Query query = em.createNativeQuery("{call saveOrder(?,?)}",
                Goods.class)
                .setParameter(1, order.getUserId())
                .setParameter(2, order.getGoodId())
                ;
        return query.executeUpdate();
    }


    public int delete(int id)throws SQLException {
        Query query = em.createNativeQuery("{call deleteOrder(?)}",
                Category.class)
                .setParameter(1, id)
                ;
        return query.executeUpdate();
    }

    public ArrayList<Order> findOrdersByUsername(String username){
        Query query = em.createNativeQuery("{call findOrdersByUsername(?)}", Order.class)
                .setParameter(1, username)
                ;
        return new ArrayList<Order>(query.getResultList());
    }

}
