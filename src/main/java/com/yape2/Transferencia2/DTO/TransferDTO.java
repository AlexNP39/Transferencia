package com.yape2.Transferencia2.DTO;

import com.yape2.Transferencia2.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

public class TransferDTO {
    private Long id;
    private AccountDTO sourceAccount;
    private AccountDTO destinationAccount;
    private BigDecimal amount;
    private String currency;

    public TransferDTO() {
    }

    public TransferDTO(Long id, AccountDTO sourceAccount, AccountDTO destinationAccount, BigDecimal amount, String currency) {
        this.id = id;
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
        this.currency = currency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountDTO getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(AccountDTO sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public AccountDTO getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(AccountDTO destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
