package com.personal.itau_transaction_api.service;

import com.personal.itau_transaction_api.controller.dtos.StatisticsResponseDTO;
import com.personal.itau_transaction_api.controller.dtos.TransactionalDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StatisticsService {

    public final TransactionalService transactionalService;

    public StatisticsResponseDTO calculateTransactionStatistics(Integer searchRange) {

        log.info("Search for transaction statistics has begun");
        List<TransactionalDTO> transactions = transactionalService.searchAllTransactions(searchRange);

        if(transactions.isEmpty()) {
            return new StatisticsResponseDTO(0L, 0.0, 0.0, 0.0, 0.0);
        }

        DoubleSummaryStatistics transactionalStatistics = transactions.stream()
                .mapToDouble(TransactionalDTO::value).summaryStatistics();

        log.info("Statistics returned successfully");
        return new StatisticsResponseDTO(transactionalStatistics.getCount(), transactionalStatistics.getSum(), transactionalStatistics.getAverage(), transactionalStatistics.getMin(), transactionalStatistics.getMax());

    }

}
