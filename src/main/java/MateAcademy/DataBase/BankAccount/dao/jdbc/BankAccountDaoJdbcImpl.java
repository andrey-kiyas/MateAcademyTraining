package MateAcademy.DataBase.BankAccount.dao.jdbc;

import MateAcademy.DataBase.BankAccount.dao.BankAccountDao;
import MateAcademy.DataBase.BankAccount.model.BankAccount;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class BankAccountDaoJdbcImpl implements BankAccountDao {
    @Override
    public BankAccount create(BankAccount bankAccount) {
        return bankAccount;
    }

    @Override
    public Optional<BankAccount> get(Long id) {
        return Optional.empty();
    }

    @Override
    public List<BankAccount> getAll() {
        return Collections.emptyList();
    }

    @Override
    public BankAccount update(BankAccount bankAccount) {
        return bankAccount;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Optional<BankAccount> findByAccountNumber(String accountNumber) {
        return Optional.empty();
    }
}
