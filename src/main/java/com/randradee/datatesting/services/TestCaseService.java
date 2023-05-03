package com.randradee.datatesting.services;

import com.randradee.datatesting.entities.TestCase;
import com.randradee.datatesting.repositories.TestCaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TestCaseService {

    @Autowired
    TestCaseRepository testCaseRepository;

    @Transactional
    public TestCase save(TestCase testCaseModel) {
        return testCaseRepository.save(testCaseModel);
    }

    public List<TestCase> findAll(){
        return testCaseRepository.findAll();
    }

    @Transactional
    public Integer addColumn(String columnName) {
        String columnType = "VARCHAR(255)";
        return testCaseRepository.addColumn(columnName);
    }

//    @Transactional
//    public void removeColumn(String columnName) {
//        testCaseRepository.removeColumn(columnName);
//    }

    public Optional findById(UUID id) {
        return testCaseRepository.findById(id);
    }

    public void delete(UUID id) {
        testCaseRepository.deleteById(id);
    }
}
