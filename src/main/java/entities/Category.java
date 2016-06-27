package entities;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity(name="category")
@Table(name="category")
public class Category
{
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private int id;
    @Column(name="title", length = 50, nullable = false)
    private String title;
    @Column(name="description", nullable = false, length = 256)
    private String description;

    public Category(){}

    private Category(String title, String description){
        this.setTitle(title);
        this.setDescription(description);
    }

    public static Category getCategory(HttpServletRequest request) throws NullPointerException, NumberFormatException{
        String number = request.getParameter("number");
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        if (titleMatches(title) & descriptionMatches(description)){
            Category category = new Category(title, description);
            if (number == null){
                return category;
            }
            else{
                category.setId(new Integer(number));
                return category;
            }
        }
        throw new NumberFormatException();
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
