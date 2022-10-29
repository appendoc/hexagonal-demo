package com.example.hexagonaldemo.documents.adapters.outbound;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "wiki_document")
public class WikiDocumentEntity {

    @Id
    @GeneratedValue
    private Long id = null;

    @Column(nullable = false)
    private String documentId;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String authorId;
}
