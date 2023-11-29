package com.automated_legal.system.models;

import lombok.Data;

@Data
public class ForumRetrievalResponse {

    private String userEmail;
    private String userName;
    private String title;
    private String content;
}
