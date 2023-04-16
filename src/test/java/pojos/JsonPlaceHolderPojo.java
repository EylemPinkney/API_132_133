package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class JsonPlaceHolderPojo {

    private Integer userId;
    private String title;
    private Boolean completed;

    public JsonPlaceHolderPojo() {
    }

    public JsonPlaceHolderPojo(Integer userId, String title, Boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "JsonPlaceHolderPojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}

/*



1-constructor
Because Im going to assing values using this constructor

2-

To create a POJO(Plain Old Java Object) Class do the followings
       1)private variables
       2)Constructor with all parameters
       3)Constructor without parameter
       4)Getters and Setters
       5)toString() method

 {
        "userId": 55,
        "title": "Tidy your room",
        "completed": false
        }


 */
