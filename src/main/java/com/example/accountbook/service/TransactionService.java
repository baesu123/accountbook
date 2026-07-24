package com.example.accountbook.service;

import com.example.accountbook.mapper.TransactionMapper;
import com.example.accountbook.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor// Mapper 주입을 위한 생성자 자동 생성
public class TransactionService {
    private final TransactionMapper transactionMapper;

    //모든 트랜젝션 가져오기
    public List<Transaction> getAllTransactions() {
        return transactionMapper.findAll();
    }

    public void addTransaction(Transaction transaction) {
        transactionMapper.save(transaction);
    }
}