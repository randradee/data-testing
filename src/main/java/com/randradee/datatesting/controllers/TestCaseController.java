package com.randradee.datatesting.controllers;

import com.randradee.datatesting.dtos.AlterColumnDTO;
import com.randradee.datatesting.entities.TestCase;
import com.randradee.datatesting.services.TestCaseService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/test-cases")
public class TestCaseController {
    @Autowired
    TestCaseService testCaseService;

    @GetMapping
    public ResponseEntity<List<TestCase>> getAllTestCases(){
        return ResponseEntity.status(HttpStatus.OK).body(testCaseService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTestCase(@PathVariable (value = "id") UUID id){
        Optional testCaseModelOptional = testCaseService.findById(id);
        if (testCaseModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Caso de teste não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(testCaseModelOptional.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTestCase(@PathVariable (value = "id") UUID id,
                                                 @RequestBody TestCase testCaseModel){
        Optional testCaseOptional = testCaseService.findById(id);
        if (testCaseOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Caso de teste não encontrado");
        }
        var testCaseModelToUpdate = new TestCase();
        BeanUtils.copyProperties(testCaseModel, testCaseModelToUpdate);

        return ResponseEntity.status(HttpStatus.OK).body(testCaseService.save(testCaseModelToUpdate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTestCase(@PathVariable (value = "id") UUID id){
        Optional testCaseOptional = testCaseService.findById(id);
        if (testCaseOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Caso de teste não encontrado.");
        }
        testCaseService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Caso de teste apagado com sucesso.");
    }

    @PostMapping
    public ResponseEntity<TestCase> createTestCase(@RequestBody TestCase testCase){
        return ResponseEntity.status(HttpStatus.CREATED).body(testCaseService.save(testCase));
    }

    @PostMapping("/add-column")
    public ResponseEntity<Integer> addColumnToTestCase(@RequestBody @Valid AlterColumnDTO alterColumnDTO){
        return ResponseEntity.status(HttpStatus.OK).body(testCaseService.addColumn(alterColumnDTO.getName()));
    }

//    @PutMapping("/add-column")
//    public ResponseEntity<Object> createNewColumn(@RequestBody @Valid AlterColumnDTO alterColumnDTO){
//
//    }
}
