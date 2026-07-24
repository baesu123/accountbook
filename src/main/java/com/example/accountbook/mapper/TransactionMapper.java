package com.example.accountbook.mapper;

import com.example.accountbook.model.Transaction;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface TransactionMapper {
    // 모든 내역 조회
    List<Transaction> findAll();

    // 내역 저장 (transaction.id가 생성되어 저장)
    void save(Transaction transaction);

    // 삭제 메서드 추가
    void deleteById(Long id);

    // 총 합계 계산 (유형별)
    Long getTotalAmountByType(String type);
}