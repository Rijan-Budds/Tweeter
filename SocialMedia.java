import java.util.HashMap;
import java.util.Map;

public class SocialMedia {
    private Map<String, User> users;
    private User loggedInUser;

    public SocialMedia(){
        users = new HashMap<>();
        loggedInUser = null;
    }

    public boolean registerUser(String username, String password){
        if(users.containsKey(username)){
            return false;
        }
        users.put(username, new User(username, password));
        return true;
    }

    public boolean loginUser(String username, String password){
        User user = users.get(username);
        if(user != null && user.checkPassword(password)){
            loggedInUser = user;
            return true;
        }
        return false;
    }

    public void logoutUser(){
        loggedInUser = null;
    }

    public boolean addFriend(String friendUsername){
        if(loggedInUser == null || !users.containsKey(friendUsername)){
            return false;
        }
        loggedInUser.addFriend(friendUsername);
        return true;
    }

    public void postUpdate(String post){
        if(loggedInUser != null){
            loggedInUser.addPost(post);
        }
    }

    public void viewFeed() {
        if (loggedInUser != null) {
            System.out.println("Your feed:");
            for (String friend : loggedInUser.getFriends()) {
                User friendUser = users.get(friend);
                if (friendUser != null) {
                    System.out.println("Posts from " + friend + ":");
                    for (String post : friendUser.getPosts()) {
                        System.out.println("- " + post);
                    }
                }
            }
       }
    }
}