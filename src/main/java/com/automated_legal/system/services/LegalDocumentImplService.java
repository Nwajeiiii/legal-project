package com.automated_legal.system.services;

import com.automated_legal.system.entities.LegalDocument;
import com.automated_legal.system.repositories.LegalDocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LegalDocumentImplService implements LegalDocumentService {

    private final LegalDocumentRepository legalDocumentRepository;


    @Override
    public List<LegalDocument> findLegalDocuments(String keyword) {
        return this.legalDocumentRepository.findByLegalDocNameContainingIgnoreCase(keyword);
    }
}
