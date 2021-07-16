package com.nhw.entitylistenertest.listener;

import com.nhw.entitylistenertest.entity.PrimaryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.PostPersist;

@Component
@RequiredArgsConstructor
public class PrimaryEntityListener {

    private final SecondaryEntityGeneratorService generatorService;

    @PostPersist
    public void postPersist(PrimaryEntity entity) {
        generatorService.generateFor(entity);
    }

}
