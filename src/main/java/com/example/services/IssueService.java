package com.example.services;

import com.example.models.Issue;

import java.util.List;

/**
 * @author tada
 */
public interface IssueService {

    List<Issue> findAll();

    void register(Issue issue, String account);

}
