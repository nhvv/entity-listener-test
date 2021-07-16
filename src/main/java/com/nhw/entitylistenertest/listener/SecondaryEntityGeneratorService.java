package com.nhw.entitylistenertest.listener;

import com.nhw.entitylistenertest.entity.PrimaryEntity;
import com.nhw.entitylistenertest.entity.SecondaryEntity;
import com.nhw.entitylistenertest.repository.SecondaryEntityRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class SecondaryEntityGeneratorService {

    private final SecondaryEntityRepository repository;

    public SecondaryEntityGeneratorService(@Lazy SecondaryEntityRepository repository) {
        this.repository = repository;
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW) //Scary shit, definitely not for prod
    public void generateFor(PrimaryEntity primary) {
        SecondaryEntity entity = SecondaryEntity
                .builder()
                .id(primary.getId())
                .summary(String.format("This was generated in response to entity described as %s", primary.getDescription()))
                .build();
        repository.save(entity);
    }
}
