package com.banktest.models;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Role implements GrantedAuthority {
    @Id
    private String id;

    @OneToMany
    private final List<Operation> allowedOperations = new ArrayList<>();

    @Override
    public String getAuthority() {
        return id;
    }

    public Collection<Operation> getAllowedOperations() {
        return allowedOperations;
    }
}
