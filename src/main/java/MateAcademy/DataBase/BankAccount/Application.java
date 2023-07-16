package MateAcademy.DataBase.BankAccount;

import MateAcademy.DataBase.BankAccount.dao.jdbc.BankAccountDaoJdbcImpl;
import MateAcademy.DataBase.BankAccount.model.BankAccount;
import MateAcademy.DataBase.BankAccount.service.BankAccountService;
import MateAcademy.DataBase.BankAccount.service.impl.BankAccountServiceImpl;
import java.math.BigDecimal;

public class Application {
    public static void main(String[] args) {
        BankAccountDaoJdbcImpl bankAccountDaoJdbc = new BankAccountDaoJdbcImpl();
        BankAccountService bankAccountService = new BankAccountServiceImpl(bankAccountDaoJdbc);

        BankAccount bobsAccount = new BankAccount();
        bobsAccount.setAmount(BigDecimal.valueOf(200));
        bobsAccount.setAccountNumber("12345");
        bobsAccount.setOwnerName("Bob");
        bankAccountService.create(bobsAccount);

        BankAccount aliceAccount = new BankAccount();
        aliceAccount.setAmount(BigDecimal.valueOf(300));
        aliceAccount.setAccountNumber("56789");
        aliceAccount.setOwnerName("Alice");
        bankAccountService.create(aliceAccount);

        bankAccountService.transfer("12345", "56789", BigDecimal.valueOf(100));
    }
}
