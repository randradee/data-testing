package com.randradee.datatesting.repositories;

import com.randradee.datatesting.models.TestCaseModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TestCaseRepository extends JpaRepository<TestCaseModel, UUID> {
}
