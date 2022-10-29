package com.example.hexagonaldemo.users.adapters.outbound;

import com.example.hexagonaldemo.users.application.port.outbound.LoadUserPort;
import com.example.hexagonaldemo.users.application.port.outbound.SaveUserPort;
import com.example.hexagonaldemo.users.domain.WikiUser;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class WikiUserEntityRepository implements LoadUserPort, SaveUserPort {

    private final WikiUserEntityJpaRepository wikiUserEntityJpaRepository;

    public WikiUserEntityRepository(WikiUserEntityJpaRepository wikiUserEntityJpaRepository) {
        this.wikiUserEntityJpaRepository = wikiUserEntityJpaRepository;
    }

    @Override
    public WikiUser loadByEmail(String email) {
        final WikiUserEntity foundEntity = wikiUserEntityJpaRepository.findByEmail(email);
        if (foundEntity != null) {
            return new WikiUser(
                    foundEntity.getUserId(),
                    foundEntity.getEmail(),
                    foundEntity.getName()
            );
        }
        return null;
    }

    @Override
    public void save(WikiUser wikiUser) {
        final WikiUserEntity entityToSave = new WikiUserEntity(
                null,
                wikiUser.getId(),
                wikiUser.getEmail(),
                wikiUser.getName()
        );
        wikiUserEntityJpaRepository.save(entityToSave);
    }
}
