package com.example.hexagonaldemo.documents.domain;

public class WikiDocument {
    private final String documentId;
    private final String authorId;
    private final String content;

    public WikiDocument(String documentId, String authorId, String content) {
        this.documentId = documentId;
        this.authorId = authorId;
        this.content = content;
    }

    public String getDocumentId() {
        return documentId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getContent() {
        return content;
    }
}
