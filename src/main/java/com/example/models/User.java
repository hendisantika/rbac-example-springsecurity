package com.example.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Set;

/**
 * @author kawasima
 * @author tada
 */
@Entity
@Table(name = "USERS")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long userId;

    @NonNull
    private String account;

    @NonNull
    private String lastName;

    @NonNull
    private String firstName;

    @NonNull
    private String password; // added for Spring Security

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "USER_ROLE",
            joinColumns = {@JoinColumn(name = "USER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID")}
    )
    private Set<Role> roles;
}
