drop table if exists transactions;

CREATE TABLE transactions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,    -- 내역 명
    amount BIGINT NOT NULL,           -- 금액
    type VARCHAR(10) NOT NULL,      -- INCOME(수입) 또는 EXPENSE(지출)
    category VARCHAR(50),           -- 카테고리 (식비, 교통비 등)
    reg_date DATETIME DEFAULT CURRENT_TIMESTAMP -- 등록일
);