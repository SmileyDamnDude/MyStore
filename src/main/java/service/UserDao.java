package service;

import entities.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class UserDao
{
    @PersistenceContext(unitName = "Store")
    private EntityManager em;

    public void save(User user)
    {
        em.persist(user);
    }

    public ArrayList<User> findByUsername(String username)
    {
        return new ArrayList<User>(em.createQuery(
                "SELECT c FROM users c WHERE c.username = :username")
                .setParameter("username", username)
                .getResultList());
    }

    public List findById(int id)
    {
        return em.createQuery(
                "SELECT c FROM users c WHERE c.id = :id")
                .setParameter("id", id)
                .getResultList();
    }

    public List findAll() {
        return em.createQuery("select u from users u").getResultList();
    }

}
