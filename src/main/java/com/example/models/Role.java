package com.example.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

/**
 * @author kawasima
 */
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Role {
    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long roleId;

    @NonNull
    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ROLE_PERMISSION")
    private Set<Permission> permissions;

    @Override
    public int hashCode() {
        if (roleId != null) {
            return roleId.hashCode();
        } else if (name != null) {
            return name.hashCode();
        }

        return 0;
    }

    @Override
    public boolean equals(Object another) {
        if (another == null || !(another instanceof Role anotherRole))
            return false;

        return anotherRole.roleId != null && (anotherRole.roleId == this.roleId);
    }

    @Override
    public String toString() {
        return name;
    }
}
