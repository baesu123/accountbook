package com.example.accountbook.controller;

import com.example.accountbook.model.Transaction;
import com.example.accountbook.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    // 가계부 메인 페이지 (목록 조회) - form 객체 바인딩 transaction을 전달
    @GetMapping("/")
    public String index(@RequestParam(defaultValue = "1")int page, Model model, Transaction transaction) {
        int pageSize = 10;

        model.addAttribute("transactions", transactionService.getTransactions(page, pageSize));
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", transactionService.getTotalPages(pageSize));

        // 기존 합계 로직 유지
        model.addAttribute("totalIncome", transactionService.getTotalIncome());
        model.addAttribute("totalExpense", transactionService.getTotalExpense());

        return "index";
    }

    // 내역 저장 처리
    @PostMapping("/add")
    public String addTransaction(@Valid Transaction transaction,
                                 BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            // 에러가 있다면 목록을 다시 담아서 페이지 유지
            model.addAttribute("transactions", transactionService.getAllTransactions());
            model.addAttribute("totalIncome", transactionService.getTotalIncome());
            model.addAttribute("totalExpense", transactionService.getTotalExpense());
            return "index"; // index.html로 돌아가기
        }
        transactionService.addTransaction(transaction);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTransaction(@PathVariable Long id) {
        transactionService.removeTransaction(id);
        return "redirect:/";
    }
}
