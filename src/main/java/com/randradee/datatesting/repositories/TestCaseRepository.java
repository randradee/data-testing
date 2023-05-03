package com.randradee.datatesting.repositories;

import com.randradee.datatesting.entities.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TestCaseRepository extends JpaRepository<TestCase, UUID> {
    @Modifying
    @Query(value = "alter table TB_TEST_CASE add column :columnName VARCHAR(255)", nativeQuery = true)
    int addColumn (@Param("columnName") String columnName);

}
