package com.nhw.entitylistenertest.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Data
public class SecondaryEntity {

    @Id
    @Column
    private Long id;

    @Column
    private String summary;

}
