package com.example.hexagonaldemo.users.adapters.outbound;

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
@Table(name = "wiki_user")
public class WikiUserEntity {

    @Id
    @GeneratedValue
    private Long id = null;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;
}
