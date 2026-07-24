package com.example.accountbook.mapper;

import com.example.accountbook.model.Transaction;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface TransactionMapper {
    // 모든 내역 조회
    List<Transaction> findAll();

    // 내역 저장
    void save(Transaction transaction);
}