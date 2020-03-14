package org.uzh.ase.users.models;

import org.springframework.data.annotation.Id;

public class User {
    @Id
    public String id;

    public String name;
    public String email;

    public User() {}

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%s, name='%s']",
                id, name);
    }

}