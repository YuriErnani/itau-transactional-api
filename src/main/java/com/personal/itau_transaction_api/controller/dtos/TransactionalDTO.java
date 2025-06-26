package com.personal.itau_transaction_api.controller.dtos;

import java.time.OffsetDateTime;

public record TransactionalDTO(Double value, OffsetDateTime dateTime) {
}
