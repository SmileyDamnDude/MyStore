package entities;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity(name="goods")
@Table(name="goods")
public class Goods
{
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private int id;
    @Column(name="categoryId", nullable = false)
    private int categoryId;
    @Column(name="title", nullable = false, length = 50)
    private String title;
    @Column(name="price", nullable = false)
    private Double price;
    @Column(name="count", nullable = false)
    private int count;
    @Column(name="description", nullable = false, length = 256)
    private String description;

    public Goods(){}

    //getgoods



    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="categoryId", insertable = false, updatable = false)
    private
    Category category;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
