import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SocialMedia {
    private HashMap<String, String> users = new HashMap<>();
    private HashMap<String, List<String>> posts = new HashMap<>();
    private static final String USERS_FILE = "users.txt";
    private static final String POSTS_FILE = "posts.txt";

    public SocialMedia() {
        loadUsersFromFile();
        loadPostsFromFile();
    }

    public boolean registerUser(String username, String password) {
        if (users.containsKey(username)) {
            return false; 
        }
        users.put(username, password);
        saveUsersToFile();
        return true;
    }

    public boolean loginUser(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }

    public void addPost(String username, String content) {
        posts.putIfAbsent(username, new ArrayList<>());
        posts.get(username).add(content);
        savePostsToFile();
    }

    public List<String> getPosts() {
        List<String> allPosts = new ArrayList<>();
        for (List<String> userPosts : posts.values()) {
            allPosts.addAll(userPosts);
        }
        return allPosts;
    }

    private void saveUsersToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USERS_FILE))) {
            for (String username : users.keySet()) {
                String password = users.get(username);
                writer.write(username + "," + password);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }

    private void loadUsersFromFile() {
        File file = new File(USERS_FILE);
        if (!file.exists()) {
            return; 
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String username = parts[0];
                    String password = parts[1];
                    users.put(username, password);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading users: " + e.getMessage());
        }
    }

    private void savePostsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(POSTS_FILE))) {
            for (String username : posts.keySet()) {
                for (String post : posts.get(username)) {
                    writer.write(username + ":" + post);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error saving posts: " + e.getMessage());
        }
    }

    private void loadPostsFromFile() {
        File file = new File(POSTS_FILE);
        if (!file.exists()) {
            return; 
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":", 2);
                if (parts.length == 2) {
                    String username = parts[0];
                    String post = parts[1];
                    posts.putIfAbsent(username, new ArrayList<>());
                    posts.get(username).add(post);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading posts: " + e.getMessage());
        }
    }
}
