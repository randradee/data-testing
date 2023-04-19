package com.randradee.datatesting.controllers;

import com.randradee.datatesting.dtos.AlterColumnDTO;
import com.randradee.datatesting.models.TestCaseModel;
import com.randradee.datatesting.services.TestCaseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api/v1/test-case")
public class TestCaseController {

    @Autowired
    TestCaseService testCaseService;

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
