package com.randradee.datatesting.controllers;

import com.randradee.datatesting.dtos.AlterColumnDTO;
import com.randradee.datatesting.models.TestCaseModel;
import com.randradee.datatesting.services.TestCaseService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/test-case")
public class TestCaseController {

    @Autowired
    TestCaseService testCaseService;

    @GetMapping
    public ResponseEntity<List<TestCaseModel>> getAllTestCases(){
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
                                                 @RequestBody TestCaseModel testCaseModel){
        Optional testCaseModelOptional = testCaseService.findById(id);
        if (testCaseModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Caso de teste não encontrado");
        }
        var testCaseModelToUpdate = new TestCaseModel();
        BeanUtils.copyProperties(testCaseModel, testCaseModelToUpdate);

        return ResponseEntity.status(HttpStatus.OK).body(testCaseService.save(testCaseModelToUpdate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTestCase(@PathVariable (value = "id") UUID id){
        Optional testCaseModelOptional = testCaseService.findById(id);
        if (testCaseModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Caso de teste não encontrado.");
        }
        testCaseService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Caso de teste apagado com sucesso.");
    }

    @PostMapping
    public ResponseEntity<TestCaseModel> createTestCase(@RequestBody TestCaseModel testCaseModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(testCaseService.save(testCaseModel));
    }

    @PutMapping("/alter-column")
    public ResponseEntity<Object> createNewColumn(@RequestBody @Valid AlterColumnDTO alterColumnDTO){
        if (Objects.equals(alterColumnDTO.getAddOrDelete(), "add")){
            testCaseService.addColumn(alterColumnDTO.getName());
            return ResponseEntity.status(HttpStatus.OK).body("Coluna " + alterColumnDTO.getName() + " criada com sucesso");
        } else if (Objects.equals(alterColumnDTO.getAddOrDelete(), "delete")){
            testCaseService.removeColumn(alterColumnDTO.getName());
            return ResponseEntity.status(HttpStatus.OK).body("Coluna " + alterColumnDTO.getName() + " apagada com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("É necessário especificar se deseja adicionar ou " +
                    "apagar uma coluna");
        }
    }
}
