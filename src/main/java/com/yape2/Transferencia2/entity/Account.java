package com.yape2.Transferencia2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Entity

@Table(name = "tb_account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user; //numero de celular

    @Column(name = "accountNumber", nullable = false)
    private String accountNumber;

    @Column(name = "balance", nullable = false)
    private BigDecimal balance;

    public Account() {
    }

    public Account(Long id, User user, String accountNumber, BigDecimal balance) {
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
