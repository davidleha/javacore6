package module4;

/**
 * Created by leha on 23.02.17.
 */
public interface BankSystem {
    void withdrawOfUser(User user, int amount);
    void fundUser(User user, int amount);
    void transferMoney(User fromUser, User toUser, int amount);
    void paySalary(User user);
}

class BankSystemImpl implements BankSystem {
    @Override
    public void withdrawOfUser(User user, int amount) {
       Bank bank = user.getBank();
       if (amount > user.getBalance()) return;
       user.setBalance(user.getBalance() - amount * (1 + (double)bank.getCommission(amount) / 100));
    }
    @Override
    public void fundUser(User user, int amount) {
        Bank bank = user.getBank();
        if (amount > bank.getLimitOfFunding()) amount = bank.getLimitOfFunding();
        if (amount > user.getBalance()) return;
        user.setBalance(user.getBalance() - amount);
        bank.setTotalCapital(bank.getTotalCapital() + amount);
    }
    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {
        Bank fromBank = fromUser.getBank();
        Bank toBank = toUser.getBank();
        if (fromBank.getCurrency() != toBank.getCurrency()) return;
        if (amount > fromUser.getBalance()) return;
        if (fromUser == toUser) return;
        fromUser.setBalance(fromUser.getBalance() - amount);
        toUser.setBalance(toUser.getBalance() + amount - amount * (double)toBank.getCommission(amount) / 100);
    }
    @Override
    public void paySalary(User user) {
        Bank bank = user.getBank();
        user.setMonthsOfEmployment(user.getMonthsOfEmployment() + 1);
        user.setBalance(user.getBalance() + user.getSalary());
    }
}