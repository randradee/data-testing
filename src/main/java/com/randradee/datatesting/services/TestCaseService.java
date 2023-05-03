package com.randradee.datatesting.services;

import com.randradee.datatesting.entities.TestCase;
import com.randradee.datatesting.repositories.TestCaseRepositoryImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TestCaseService {

    @Autowired
    TestCaseRepositoryImpl testCaseRepository;


    @Transactional
    public TestCase save(TestCase testCaseModel) {
        return testCaseRepository.save(testCaseModel);
    }

    public List<TestCase> findAll(){
        return testCaseRepository.findAll();
    }

    public void addColumn(String columnName) {
        String columnType = "VARCHAR(255)";
        testCaseRepository.addColumnToTable("TB_TEST_CASE", columnName, columnType);
    }

    public void removeColumn(String columnName) {
        testCaseRepository.removeColumnFromTable("TB_TEST_CASE", columnName);
    }

    public Optional findById(UUID id) {
        return testCaseRepository.findById(id);
    }

    public void delete(UUID id) {
        testCaseRepository.deleteById(id);
    }
}
