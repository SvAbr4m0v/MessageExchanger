package basePackage.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@Table(name = "post")
@Embeddable
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    private String postHeader;

    private Long amountOfLikes;

    @JoinColumn(name = "userPage_id")
    @ManyToOne
    UserPage userPage;

    public Post(String message, String postHeader, UserPage userPage) {
        this.message = message;
        this.postHeader = postHeader;
        this.userPage = userPage;
        this.amountOfLikes = 0l;
    }

    public void EditPost(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return userPage.getUser() + ": " + message;
    }

    public void increaseAmountOfLikes() {
        this.amountOfLikes++;
    }

    public void decreaseAmountOfLikes() {
        if (amountOfLikes > 0) {
            this.amountOfLikes--;
        }
    }

    public String getMessage() {
        return message;
    }

    public Long getId() {
        return this.id;
    }
}
