package com.zaur.transaction_service.dto;


import com.zaur.transaction_service.model.Category;
import com.zaur.transaction_service.model.Currency;
import com.zaur.transaction_service.model.TransactionType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class TransactionResponse {

    UUID transactionId;
    BigDecimal amount;
    String description;
    TransactionType type;
    Category category;
    Currency currency;
    LocalDate transactionDate;

}
