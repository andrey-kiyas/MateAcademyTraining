package MateAcademy.DataBase.BankAccount.service.impl;

import MateAcademy.DataBase.BankAccount.dao.BankAccountDao;
import MateAcademy.DataBase.BankAccount.model.BankAccount;
import MateAcademy.DataBase.BankAccount.service.BankAccountService;
import java.math.BigDecimal;
import java.util.Optional;

public class BankAccountServiceImpl implements BankAccountService {
    private BankAccountDao bankAccountDao;

    public BankAccountServiceImpl(BankAccountDao bankAccountDao) {
        this.bankAccountDao = bankAccountDao;
    }

    @Override
    public void transfer(String fromAccount, String toAccount, BigDecimal amount) {
        Optional<BankAccount> senderAccount = bankAccountDao.findByAccountNumber(fromAccount);
        Optional<BankAccount> receiverAccount = bankAccountDao.findByAccountNumber(toAccount);

        if(senderAccount.isEmpty() || receiverAccount.isEmpty()){
            throw new RuntimeException("Can't find account...");
        }
        senderAccount.get().setAmount(senderAccount.get().getAmount().subtract(amount));
        receiverAccount.get().setAmount(receiverAccount.get().getAmount().add(amount));

        bankAccountDao.update(senderAccount.get());
        bankAccountDao.update(receiverAccount.get());
    }

    @Override
    public BankAccount create(BankAccount bankAccount) {
        return bankAccountDao.create(bankAccount);
    }
}
