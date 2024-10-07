package ru.job4j.map;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class User {

    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        Calendar birthday = Calendar.getInstance();
        User user1 = new User("Ivan", 2, birthday);
        int hashcode1 = user1.hashCode();
        int hash1 = hashcode1 ^ (hashcode1 >>> 16);
        int bucket1 = hash1 & 15;
        User user2 = new User("Ivan", 2, birthday);
        int hashcode2 = user2.hashCode();
        int hash2 = hashcode2 ^ (hashcode2 >>> 16);
        int bucket2 = hash2 & 15;
        Map<User, Object> map = new HashMap<>(16);
        map.put(user1, new Object());
        map.put(user2, new Object());
        System.out.printf("User1-hashcode: %s, hash1: %s, bucket1: %s",
                hashcode1, hash1, bucket1);
        System.out.println();
        System.out.printf("User2-hashcode: %s, hash2: %s, bucket2: %s",
                hashcode2, hash2, bucket2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

        @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User user)) {
            return false;
        }
        return children == user.children && Objects.equals(name, user.name) && Objects.equals(birthday, user.birthday);
    }
}
