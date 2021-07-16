package com.nhw.entitylistenertest.listener;

import com.nhw.entitylistenertest.entity.PrimaryEntity;
import com.nhw.entitylistenertest.entity.SecondaryEntity;
import com.nhw.entitylistenertest.repository.PrimaryEntityRepository;
import com.nhw.entitylistenertest.repository.SecondaryEntityRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class PrimaryEntityListenerTest {

    @Autowired
    private PrimaryEntityRepository primaryRepository;

    @Autowired
    private SecondaryEntityRepository secondaryRepository;

    @Test
    void shouldUpdateOtherAfterPersistingPrimary() {
        Long id = 1L;
        assertFalse(primaryRepository.findById(id).isPresent());
        assertEquals(0, secondaryRepository.count());

        String description = "My Test description";
        PrimaryEntity primaryEntity = PrimaryEntity.builder().id(id).description(description).build();
        primaryRepository.save(primaryEntity);

        assertTrue(primaryRepository.findById(id).isPresent());
        assertEquals(1, secondaryRepository.count());
        Optional<SecondaryEntity> maybeSecondary = secondaryRepository.findById(id);
        assertTrue(maybeSecondary.isPresent());
        SecondaryEntity secondary = maybeSecondary.get();
        assertTrue(secondary.getSummary().contains(description));
    }
}