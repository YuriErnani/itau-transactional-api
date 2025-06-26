package com.personal.itau_transaction_api.controller;

import com.personal.itau_transaction_api.controller.dtos.StatisticsResponseDTO;
import com.personal.itau_transaction_api.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistics")
@RequiredArgsConstructor
public class StatisticsController {

    private final StatisticsService statisticsService;

    public ResponseEntity<StatisticsResponseDTO> searchStatistics(@RequestParam(value = "searchRange", required = false, defaultValue = "60") Integer searchRange) {
        return ResponseEntity.ok(statisticsService.calculateTransactionStatistics(searchRange));
    }

}
