package com.zaur.transaction_service.dto;


import com.zaur.transaction_service.model.Currency;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class BalanceResponse {

    Currency currency;

    BigDecimal income;

    BigDecimal expense;

    BigDecimal balance;

}
