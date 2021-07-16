package com.nhw.entitylistenertest.repository;

import com.nhw.entitylistenertest.entity.PrimaryEntity;
import org.springframework.data.repository.CrudRepository;

public interface PrimaryEntityRepository extends CrudRepository<PrimaryEntity, Long> {
}
