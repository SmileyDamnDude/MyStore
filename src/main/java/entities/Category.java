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

//saw

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
