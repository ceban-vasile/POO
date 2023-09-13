package challenges_0;

public class User {
    String firstName, lastName;

    public User(String fistName, String lastName){
        this.firstName = fistName;
        this.lastName = lastName;
    }

    public static void main(String[] args){
        User user = new User("Ion","Doe");
        System.out.println(user.firstName);
    }
}
