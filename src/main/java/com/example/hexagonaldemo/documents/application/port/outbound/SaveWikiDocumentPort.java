package com.example.hexagonaldemo.documents.application.port.outbound;

import com.example.hexagonaldemo.documents.domain.WikiDocument;

public interface SaveWikiDocumentPort {

    void save(WikiDocument wikiDocument);
}
