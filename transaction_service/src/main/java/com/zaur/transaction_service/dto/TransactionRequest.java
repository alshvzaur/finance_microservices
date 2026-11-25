package com.zaur.transaction_service.dto;


import com.zaur.transaction_service.model.Category;
import com.zaur.transaction_service.model.Currency;
import com.zaur.transaction_service.model.TransactionType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class TransactionRequest {

    @NotNull(message = "Type is required")
    TransactionType type;

    @Positive
    @NotNull(message = "Enter amount")
    BigDecimal amount;

    @NotNull(message = "Currency is required")
    Currency currency;

    @NotNull(message = "Select category")
    Category category;

    String description;

    @NotNull(message = "Enter date")
    LocalDate date;
}
