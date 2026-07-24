package com.example.accountbook.controller;

import com.example.accountbook.model.Transaction;
import com.example.accountbook.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    // 가계부 메인 페이지 (목록 조회)
    @GetMapping("/")
    public String index(Model model) {
        //Mode 객체는 View에 데이터 전달을 위한 객체(request)
        model.addAttribute("transactions", transactionService.getAllTransactions());
        return "index";
    }
    // 내역 저장 처리
    @PostMapping("/add")
    public String addTransaction(Transaction transaction) {
        transactionService.addTransaction(transaction);
        return "redirect:/"; // 저장 후 메인 페이지로 리다이렉트
    }


}
