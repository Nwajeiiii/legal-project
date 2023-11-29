package com.automated_legal.system.models;

import lombok.Data;

@Data
public class ForumCreationRequest {

    private String userEmail;

    private String title;

    private String content;

}
