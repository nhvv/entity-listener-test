package com.nhw.entitylistenertest.repository;

import com.nhw.entitylistenertest.entity.SecondaryEntity;
import org.springframework.data.repository.CrudRepository;

public interface SecondaryEntityRepository extends CrudRepository<SecondaryEntity, Long> {
}
