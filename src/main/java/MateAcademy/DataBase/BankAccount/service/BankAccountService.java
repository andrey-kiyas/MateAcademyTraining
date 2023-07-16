package MateAcademy.DataBase.BankAccount.service;

import MateAcademy.DataBase.BankAccount.model.BankAccount;
import java.math.BigDecimal;

public interface BankAccountService {
    void transfer(String fromAccount, String toAccount, BigDecimal amount);

    BankAccount create(BankAccount bankAccount);
}
