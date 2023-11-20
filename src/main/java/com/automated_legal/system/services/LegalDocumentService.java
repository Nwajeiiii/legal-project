package com.automated_legal.system.services;

import com.automated_legal.system.entities.LegalDocument;

import java.util.List;

public interface LegalDocumentService {

    List<LegalDocument> findLegalDocuments(String keyword);

}
