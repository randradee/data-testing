package com.randradee.datatesting.services;

import com.randradee.datatesting.models.TestCaseModel;
import com.randradee.datatesting.repositories.TestCaseRepository;
import com.randradee.datatesting.repositories.TestCaseRepositoryNative;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public List<TestCaseModel> findAll(){
        return testCaseRepository.findAll();
    }

    @Transactional
    public void addColumn(String columnName) {
        String tableName = "TB_TEST_CASE";
        String columnType = "VARCHAR(255)";

        testCaseRepositoryNative.addColumn(tableName, columnName, columnType);
    }

    @Transactional
    public void removeColumn(String columnName) {
        String tableName = "TB_TEST_CASE";

        testCaseRepositoryNative.removeColumn(tableName, columnName);
    }

    public Optional findById(UUID id) {
        return testCaseRepository.findById(id);
    }

    public void delete(UUID id) {
        testCaseRepository.deleteById(id);
    }
}
