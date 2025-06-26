package com.personal.itau_transaction_api.service;

import com.personal.itau_transaction_api.controller.dtos.TransactionalDTO;
import com.personal.itau_transaction_api.infrastructure.exceptions.UnprocessableEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionalService {

    private final List<TransactionalDTO> transactionaList = new ArrayList<>();

    public void createRequestTransactional(TransactionalDTO transactionalDTO) {

        log.info("Starting the transaction saving process");

        if(transactionalDTO.dateTime().isAfter(OffsetDateTime.now())) {
            log.info("Invalid date and time");
            throw new UnprocessableEntity("Invalid date and time");
        }

        if(transactionalDTO.value() < 0) {
            log.info("Value provided cannot be less than zero");
            throw new UnprocessableEntity("Value provided cannot be less than zero");
        }

        transactionaList.add(transactionalDTO);

    }

    public void deleteAllTransactional() {
        transactionaList.clear();
    }

    public List<TransactionalDTO> searchAllTransactions(Integer searchRange) {

        OffsetDateTime dateAndTimeRange = OffsetDateTime.now().minusSeconds(searchRange);

        return transactionaList.stream()
                .filter(t -> t.dateTime().isAfter(dateAndTimeRange)).toList();

    }

}
