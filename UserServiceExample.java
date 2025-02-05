import java.util.Optional;


interface UserService {

    default String getWelcomeMessage() {
        return "Welcome, Guest!";
    }

    Optional<String> getUser(String name);

    default String getPersonalizedWelcome(String name) {
        return getUser(name)
                .map(userName -> "Welcome, " + userName + "!")
                .orElse(getWelcomeMessage());
    }
}

class UserServiceImpl implements UserService {
    @Override
    public Optional<String> getUser(String name) {
        return Optional.ofNullable(name); 
    }
}

public class UserServiceExample {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        String welcomeMessage1 = userService.getPersonalizedWelcome("Alice");
        String welcomeMessage2 = userService.getPersonalizedWelcome(null);
        String welcomeMessage3 = userService.getPersonalizedWelcome("Bob");

        System.out.println(welcomeMessage1); 
        System.out.println(welcomeMessage2); 
        System.out.println(welcomeMessage3); 
    }
}
