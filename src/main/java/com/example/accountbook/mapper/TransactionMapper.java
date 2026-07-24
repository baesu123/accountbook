package com.example.accountbook.mapper;

import com.example.accountbook.model.Transaction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TransactionMapper {
    // 모든 내역 조회
    List<Transaction> findAll();
    // 내역 저장 (transaction.id 가 생성되어 저장)
    void save(Transaction transaction);
    // 삭제 메서드 추가
    void deleteById(Long id);
    // 총 합계 계산 (유형별 수입, 지출)
    Long getTotalAmountByType(String type);
    // 파라미터로 시작 위치(offset)와 한 페이지당 개수(limit)를 전달
    List<Transaction> findPaged(
            @Param("offset") int offset,
            @Param("limit") int limit,
            @Param("startDate") String startDate,
            @Param("endDate") String endDate,
            @Param("category") String category
    );
    // 전체 데이터 개수 조회 (페이지 번호 계산용)
    int countAll(
            @Param("startDate") String startDate,
            @Param("endDate") String endDate,
            @Param("category") String category
    );
}