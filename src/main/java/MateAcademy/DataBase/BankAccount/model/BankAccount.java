package MateAcademy.DataBase.BankAccount.model;

import java.math.BigDecimal;

public class BankAccount {
    private Long id;
    private BigDecimal amount;
    private String accountNumber;
    private String ownerName;

    public Long getId() {
        return id;
    }

    public BankAccount setId(Long id) {
        this.id = id;
        return this;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BankAccount setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BankAccount setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public BankAccount setOwnerName(String ownerName) {
        this.ownerName = ownerName;
        return this;
    }
}
