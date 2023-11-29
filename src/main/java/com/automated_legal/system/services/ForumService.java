package com.automated_legal.system.services;

import com.automated_legal.system.entities.Forum;
import com.automated_legal.system.models.ForumCreationRequest;
import com.automated_legal.system.models.ForumCreationResponse;
import com.automated_legal.system.models.ForumRetrievalResponse;

import java.util.List;

public interface ForumService {

    List<ForumRetrievalResponse> getAllForums();

    ForumCreationResponse createNewForum(ForumCreationRequest request);

}
