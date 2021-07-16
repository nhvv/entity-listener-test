package com.nhw.entitylistenertest.entity;

import com.nhw.entitylistenertest.listener.PrimaryEntityListener;
import lombok.*;

import javax.persistence.*;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@EntityListeners(PrimaryEntityListener.class)
@Data
public class PrimaryEntity {

    @Id
    @Column
    private Long id;

    @Column
    private String description;

}
