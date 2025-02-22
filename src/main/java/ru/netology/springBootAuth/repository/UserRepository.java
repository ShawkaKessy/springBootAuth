package ru.netology.springBootAuth.repository;

import ru.netology.springBootAuth.model.Authorities;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {
    private final Map<String, String> users = new HashMap<>();
    private final Map<String, List<Authorities>> authorities = new HashMap<>();

    public UserRepository() {

        users.put("admin", "admin123");
        users.put("user", "user123");

        authorities.put("admin", Arrays.asList(Authorities.READ, Authorities.WRITE, Authorities.DELETE));
        authorities.put("user", Collections.singletonList(Authorities.READ));
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (users.containsKey(user) && users.get(user).equals(password)) {
            return authorities.getOrDefault(user, Collections.emptyList());
        }
        return Collections.emptyList();
    }
}