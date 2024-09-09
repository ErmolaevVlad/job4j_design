package ru.job4j.generics;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class RoleStoreTest {

    @Test
    void whenAddAndFindThenRoleIsAdmin() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Admin"));
        Role result = store.findById("1");
        assertThat(result.getRole()).isEqualTo("Admin");
    }

    @Test
    void whenAddAndFindThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Admin"));
        Role result = store.findById("5");
        assertThat(result).isNull();
    }

    @Test
    void whenAddDuplicateAndFindRoleIsAdmin() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Admin"));
        store.add(new Role("1", "Manager"));
        Role result = store.findById("1");
        assertThat(result.getRole()).isEqualTo("Admin");
    }

    @Test
    void whenReplaceThenRoleIsManager() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Admin"));
        store.replace("1", new Role("1", "Manager"));
        Role result = store.findById("1");
        assertThat(result.getRole()).isEqualTo("Manager");
    }

    @Test
    void whenNoReplaceRoleThenNoChangeRole() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Admin"));
        store.replace("5", new Role("5", "Manager"));
        Role result = store.findById("1");
        assertThat(result.getRole()).isEqualTo("Admin");
    }

    @Test
    void whenDeleteRoleThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Admin"));
        store.delete("1");
        Role result = store.findById("1");
        assertThat(result).isNull();
    }

    @Test
    void whenNoDeleteRoleThenRoleIsAdmin() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Admin"));
        store.delete("7");
        Role result = store.findById("1");
        assertThat(result.getRole()).isEqualTo("Admin");
    }

    @Test
    void whenReplaceOkThenTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Admin"));
        boolean result = store.replace("1", new Role("1", "Manager"));
        assertThat(result).isTrue();
    }

    @Test
    void whenReplaceNotOkThenFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Admin"));
        boolean result = store.replace("4", new Role("4", "Manager"));
        assertThat(result).isFalse();
    }
}