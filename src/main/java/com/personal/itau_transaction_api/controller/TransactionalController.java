package com.personal.itau_transaction_api.controller;

import com.personal.itau_transaction_api.service.TransactionalService;
import com.personal.itau_transaction_api.controller.dtos.TransactionalDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(description = "Endpoint responsible for adding transactions")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Transaction recorded successfully"),
            @ApiResponse(responseCode = "422", description = "Fields do not meet transaction requirements"),
            @ApiResponse(responseCode = "400",description = "Request error"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Void> createRequestTransactional(@RequestBody TransactionalDTO transactionalDTO) {

        transactionalService.createRequestTransactional(transactionalDTO);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @Operation(description = "Endpoint responsible for deleting transactions")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Transaction recorded successfully"),
            @ApiResponse(responseCode = "400",description = "Request error"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping
    public ResponseEntity<Void> deleteAllTransactional() {

        transactionalService.deleteAllTransactional();

        return ResponseEntity.ok().build();

    }

}
