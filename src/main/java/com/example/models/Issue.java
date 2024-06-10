package com.example.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author kawasima
 */
@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Issue {
    @Id
    @GeneratedValue
    private Long issueId;

    @NonNull
    private String subject;

    @NonNull
    private String description;

    @ManyToOne
    private User postedBy;
}
