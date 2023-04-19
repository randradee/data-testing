package com.randradee.datatesting.services;

import com.randradee.datatesting.models.TestCaseModel;
import com.randradee.datatesting.repositories.TestCaseRepository;
import com.randradee.datatesting.repositories.TestCaseRepositoryNative;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestCaseService {

    @Autowired
    TestCaseRepositoryNative testCaseRepositoryNative;

    @Autowired
    TestCaseRepository testCaseRepository;

    @Transactional
    public TestCaseModel save(TestCaseModel testCaseModel) {
        return testCaseRepository.save(testCaseModel);
    }

    public void addColumn(String columnName) {
        String tableName = "TB_TEST_CASE";
        String columnType = "VARCHAR(255)";

        testCaseRepositoryNative.addColumn(tableName, columnName, columnType);
    }

    public void removeColumn(String columnName) {
        String tableName = "TB_TEST_CASE";
        String columnType = "VARCHAR(255)";

        testCaseRepositoryNative.removeColumn(tableName, columnName);
    }
}
