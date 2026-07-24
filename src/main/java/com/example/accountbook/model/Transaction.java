package com.example.accountbook.model;

import jakarta.validation.Validation;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter @Setter
public class Transaction {
    private Long id;

    @NotBlank(message = "내역을 입력해주세요")
    @Size(max=50,message = "내역은 50자 이내로 입력해주세요")
    private String title;

    @NotNull(message = "금액을 입력해주세요")
    @Min(value = 1, message = "금액은 1원이어야 합니다")
    @Max(value = 100000000, message = "금액이 너무 큽니다")
    private Long amount;

    @NotBlank(message = "유형을 선택해주세요")
    private String type;     // INCOME, EXPENSE
    private String category;
    private LocalDateTime regDate;
}