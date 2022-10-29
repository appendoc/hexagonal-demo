package com.example.hexagonaldemo.documents.adapters.outbound;

import com.example.hexagonaldemo.documents.application.port.outbound.SaveWikiDocumentPort;
import com.example.hexagonaldemo.documents.domain.WikiDocument;
import org.springframework.stereotype.Repository;

@Repository
public class WikiDocumentEntityRepository implements SaveWikiDocumentPort {

    private final WikiDocumentEntityJpaRepository wikiDocumentEntityJpaRepository;

    public WikiDocumentEntityRepository(WikiDocumentEntityJpaRepository wikiDocumentEntityJpaRepository) {
        this.wikiDocumentEntityJpaRepository = wikiDocumentEntityJpaRepository;
    }

    @Override
    public void save(WikiDocument wikiDocument) {
        final WikiDocumentEntity wikiDocumentEntity = new WikiDocumentEntity(
                null,
                wikiDocument.getDocumentId(),
                wikiDocument.getContent(),
                wikiDocument.getAuthorId()
        );
        wikiDocumentEntityJpaRepository.save(wikiDocumentEntity);
    }
}
