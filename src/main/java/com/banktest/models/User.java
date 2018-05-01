package com.banktest.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    private String firstName;
    private String lastName;


    @OneToMany
    private final List<Role> roles = new ArrayList<>();

    public Collection<Role> getRoles() {
        return roles;
    }

    public User(String firstName, String lastName ) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
            "Customer[id=%d, firstName='%s', lastName='%s']",
            id, firstName, lastName);
    }
}
