import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private List <String> friends;
    private List <String> posts;

    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.friends = new ArrayList<String>();
        this.posts = new ArrayList<String>();
    }

    public String getUserName(){
        return username;
    }

    public boolean checkPassword(String password){
        return this.password.equals(password);
    }

    public void addFriend(String friend){
        friends.add(friend);
    }

    public void addPost(String post){
        posts.add(post);
    }

    public List<String> getFriends(){
        return friends;
    }

    public List<String> getPosts(){
        return posts;
    }
}
