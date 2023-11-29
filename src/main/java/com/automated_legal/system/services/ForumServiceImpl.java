package com.automated_legal.system.services;

import com.automated_legal.system.entities.Forum;
import com.automated_legal.system.entities.User;
import com.automated_legal.system.models.ForumCreationRequest;
import com.automated_legal.system.models.ForumCreationResponse;
import com.automated_legal.system.models.ForumRetrievalResponse;
import com.automated_legal.system.repositories.ForumRepository;
import com.automated_legal.system.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ForumServiceImpl implements ForumService{

    private final ForumRepository forumRepository;
    private final UserRepository userRepository;

    @Override
    public List<ForumRetrievalResponse> getAllForums() {
        List<ForumRetrievalResponse> responses = new ArrayList<>();
        List<Forum> forums = this.forumRepository.findAll();

        forums.forEach(x -> {
            ForumRetrievalResponse response = new ForumRetrievalResponse();
            response.setUserEmail(x.getUserId().getEmail());
            response.setUserName(x.getUserId().getFullName());
            response.setContent(x.getContent());
            response.setTitle(x.getTitle());
            responses.add(response);
        });

        return responses;
    }

    @Override
    public ForumCreationResponse createNewForum(ForumCreationRequest request) {
        ForumCreationResponse response = new ForumCreationResponse();
        Forum forum = new Forum();

        User user = this.userRepository.findByEmail(request.getUserEmail());

        if(user == null) {
            response.setResponseCode("999");
            response.setResponseMessage("no such user exists");
            return response;
        }

        forum.setUserId(user);
        forum.setTitle(request.getTitle());
        forum.setContent(request.getContent());

        try {
            this.forumRepository.save(forum);
        } catch (Exception e) {
            response.setResponseMessage(e.getCause().getMessage());
            response.setResponseCode("999");
            return response;
        }

        response.setResponseMessage("successful");
        response.setResponseCode("000");
        return response;
    }
}
