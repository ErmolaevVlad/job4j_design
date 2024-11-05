package ru.job4j.question;

import java.util.HashMap;
import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0;
        int changed = 0;
        int deleted = 0;
        HashMap<Integer, User> map = new HashMap<>();
        for (var user : previous) {
            map.put(user.getId(), user);
        }
        for (var user : current) {
            if (!map.containsKey(user.getId())) {
                added++;
            }
            if (!map.containsValue(user) && map.containsKey(user.getId())) {
                changed++;
            }
            map.remove(user.getId());
        }
        deleted = map.size();
        return new Info(added, changed, deleted);
    }
}
