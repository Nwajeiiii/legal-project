package com.automated_legal.system.controllers;

import com.automated_legal.system.entities.LegalDocument;
import com.automated_legal.system.services.LegalDocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/legal-documents")
public class LegalDocumentController {

    private final LegalDocumentService legalDocumentService;

    @CrossOrigin
    @GetMapping("/{keyword}")
    public List<LegalDocument> findLegalDocuments(@PathVariable(name = "keyword") String keyword){
        return this.legalDocumentService.findLegalDocuments(keyword);
    }

}
