package entities;

import javax.persistence.*;

@Entity(name="orders")
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private int id;
    @Column(name="userId", nullable = false)
    private int userId;
    @Column(name="goodId", nullable = false)
    private int goodId;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="userId", insertable = false, updatable = false)
    private
    User user;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="goodId", insertable = false, updatable = false)
    private
    Goods goods;

    public Order(){}

    public Order(int userId, int goodId){
        this.setUserId(userId);
        this.setGoodId(goodId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
