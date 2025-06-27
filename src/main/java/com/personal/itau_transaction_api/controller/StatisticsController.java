package com.personal.itau_transaction_api.controller;

import com.personal.itau_transaction_api.controller.dtos.StatisticsResponseDTO;
import com.personal.itau_transaction_api.service.StatisticsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistics")
@RequiredArgsConstructor
public class StatisticsController {

    private final StatisticsService statisticsService;

    @Operation(description = "Endpoint responsible for fetching transaction statistics")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Search successful"),
            @ApiResponse(responseCode = "400",description = "Error searching for transaction statistics"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public ResponseEntity<StatisticsResponseDTO> searchStatistics(@RequestParam(value = "searchRange", required = false, defaultValue = "60") Integer searchRange) {
        return ResponseEntity.ok(statisticsService.calculateTransactionStatistics(searchRange));
    }

}
