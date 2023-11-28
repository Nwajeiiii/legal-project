package com.automated_legal.system.controllers;

import com.automated_legal.system.models.LawyerResponse;
import com.automated_legal.system.services.LawyerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lawyers")
public class LawyerController {

    private final LawyerService lawyerService;

    @CrossOrigin
    @GetMapping("/{keyword}")
    List<LawyerResponse> findLawyers (@PathVariable(name = "keyword") String keyword) {
        return this.lawyerService.findLawyers(keyword);
    }

}
