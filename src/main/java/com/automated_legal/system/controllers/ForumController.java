package com.automated_legal.system.controllers;

import com.automated_legal.system.entities.Forum;
import com.automated_legal.system.models.ForumCreationRequest;
import com.automated_legal.system.models.ForumCreationResponse;
import com.automated_legal.system.models.ForumRetrievalResponse;
import com.automated_legal.system.services.ForumService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/forums")
public class ForumController {

    private final ForumService forumService;

    @CrossOrigin
    @GetMapping
    public List<ForumRetrievalResponse> getAllForums() {
        return this.forumService.getAllForums();
    }

    @CrossOrigin
    @PostMapping("/create")
    public ForumCreationResponse createNewForum(@RequestBody ForumCreationRequest request){
        return this.forumService.createNewForum(request);
    }

}
