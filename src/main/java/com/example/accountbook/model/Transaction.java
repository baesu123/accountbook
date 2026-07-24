package com.example.accountbook.model;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter @Setter
public class Transaction {
    private Long id;
    private String title;
    private Long amount;
    private String type;     // INCOME, EXPENSE
    private String category;
    private LocalDateTime regDate;
}