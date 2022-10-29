package com.example.hexagonaldemo.users.adapters.outbound;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WikiUserEntityJpaRepository extends JpaRepository<WikiUserEntity, Long> {

    WikiUserEntity findByEmail(String email);
}
