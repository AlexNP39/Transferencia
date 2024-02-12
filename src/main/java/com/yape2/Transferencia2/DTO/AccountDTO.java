package com.yape2.Transferencia2.DTO;

import com.yape2.Transferencia2.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

public class AccountDTO {
    private Long id;
    private User user; //numero de celular
    private String accountNumber;
    private BigDecimal balance;

    public AccountDTO() {
    }

    public AccountDTO(Long id, User user, String accountNumber, BigDecimal balance) {
        this.id = id;
        this.user = user;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
