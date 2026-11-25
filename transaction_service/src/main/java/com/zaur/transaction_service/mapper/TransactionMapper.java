package com.zaur.transaction_service.mapper;


import com.zaur.transaction_service.dto.TransactionRequest;
import com.zaur.transaction_service.dto.TransactionResponse;
import com.zaur.transaction_service.model.Transaction;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TransactionMapper {

    public Transaction requestToTransaction(TransactionRequest transactionRequest, UUID userId) {

        return Transaction.builder()
                .userId(userId)
                .type(transactionRequest.getType())
                .amount(transactionRequest.getAmount())
                .currency(transactionRequest.getCurrency())
                .category(transactionRequest.getCategory())
                .description(transactionRequest.getDescription())
                .date(transactionRequest.getDate())
                .build();
    }

    public TransactionResponse transactionToResponse(Transaction transaction) {

        return TransactionResponse.builder()
                .transactionId(transaction.getId())
                .amount(transaction.getAmount())
                .description(transaction.getDescription())
                .type(transaction.getType())
                .category(transaction.getCategory())
                .currency(transaction.getCurrency())
                .transactionDate(transaction.getDate())
                .build();
    }
}
