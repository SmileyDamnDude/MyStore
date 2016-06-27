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

    public static Goods getGoods(HttpServletRequest request){
        String number = request.getParameter("number");
        String categoryId = request.getParameter("categoryId");
        String title = request.getParameter("title");
        String price = request.getParameter("price");
        String count = request.getParameter("count");
        String description = request.getParameter("description");
        if (titleMatches(title) & descriptionMatches(description)){
            Goods goods = new Goods(new Integer(categoryId), title, new Double(price), new Integer(count), description);
            if (number != null){
                goods.setId(new Integer(number));
            }
            return goods;
        }
        throw new NumberFormatException();
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="categoryId", insertable = false, updatable = false)
    private
    Category category;


    public static boolean titleMatches(String title){
        Pattern patternTitle = Pattern.compile("^[A-Za-zА-Яа-яЁё0-9 -]{1,50}$");
        Matcher matcherTitle = patternTitle.matcher(title);
        return matcherTitle.matches();
    }

    public static boolean descriptionMatches(String description){
        Pattern patternDescription = Pattern.compile("^[A-Za-zА-Яа-яЁё0-9 -]{0,256}$");
        Matcher matcherDescription = patternDescription.matcher(description);
        return matcherDescription.matches();
    }

    public Goods(int categoryId, String title, double price, int count, String description){
        this.setCategoryId(categoryId);
        this.setTitle(title);
        this.setPrice(price);
        this.setCount(count);
        this.setDescription(description);
    }

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
