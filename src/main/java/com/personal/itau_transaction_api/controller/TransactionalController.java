package com.personal.itau_transaction_api.controller;

import com.personal.itau_transaction_api.service.TransactionalService;
import com.personal.itau_transaction_api.controller.dtos.TransactionalDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionalController {

    private final TransactionalService transactionalService;

    @PostMapping
    public ResponseEntity<Void> createRequestTransactional(@RequestBody TransactionalDTO transactionalDTO) {

        transactionalService.createRequestTransactional(transactionalDTO);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllTransactional() {

        transactionalService.deleteAllTransactional();

        return ResponseEntity.ok().build();

    }

}
