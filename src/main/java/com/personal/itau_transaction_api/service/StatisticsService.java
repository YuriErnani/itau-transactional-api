package com.personal.itau_transaction_api.service;

import com.personal.itau_transaction_api.controller.dtos.StatisticsResponseDTO;
import com.personal.itau_transaction_api.controller.dtos.TransactionalDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticsService {

    public final TransactionalService transactionalService;

    public StatisticsResponseDTO calculateTransactionStatistics(Integer searchRange) {

        List<TransactionalDTO> transactions = transactionalService.searchAllTransactions(searchRange);

        DoubleSummaryStatistics transactionalStatistics = transactions.stream()
                .mapToDouble(TransactionalDTO::value).summaryStatistics();

        return new StatisticsResponseDTO(transactionalStatistics.getCount(), transactionalStatistics.getSum(), transactionalStatistics.getAverage(), transactionalStatistics.getMin(), transactionalStatistics.getMax());

    }

}
