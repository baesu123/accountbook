package com.example.accountbook.service;

import com.example.accountbook.mapper.TransactionMapper;
import com.example.accountbook.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionMapper transactionMapper;

    // 모든 트랜젝션 가져오기
    public List<Transaction> getAllTransactions() {
        return transactionMapper.findAll();
    }
    // 새로운 트랜젝션 입력
    public void addTransaction(Transaction transaction) {
        transactionMapper.save(transaction);
    }
    // id로 삭제하기
    public void removeTransaction(Long id) {
        transactionMapper.deleteById(id);
    }
    // 총 수익
    public Long getTotalIncome() {
        return transactionMapper.getTotalAmountByType("INCOME");
    }
    // 총 지출
    public Long getTotalExpense() {
        return transactionMapper.getTotalAmountByType("EXPENSE");
    }
    // 페이지번호, 10을 입력시 해당페이지의 10개 트랜젝션 가져옴
    public List<Transaction> getTransactions(int page, int size,
                                             String startDate, String endDate, String category) {
        int offset = (page - 1) * size;
        return transactionMapper.findPaged(offset, size, startDate, endDate, category);
    }
    // 한페이지 size 입력서 전체 페이지번호 리턴
    public int getTotalPages(int size, String startDate, String endDate, String category) {
        int totalCount = transactionMapper.countAll( startDate, endDate, category);
        return (int) Math.ceil((double) totalCount / size);
    }
}