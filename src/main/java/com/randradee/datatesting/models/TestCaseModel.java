package com.randradee.datatesting.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_TEST_CASE")
public class TestCaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "isReady")
    private Boolean isReady;

    @Column(name = "name")
    private String name;
}
