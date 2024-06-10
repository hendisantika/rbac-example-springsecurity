package com.example.repositories;

import com.example.models.Issue;

import java.util.List;

/**
 * @author kawasima
 * @author tada
 */
public interface IssueRepository {

    List<Issue> findAll();

    void register(Issue issue, String account);
}
