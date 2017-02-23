package module4;

/**
 * Created by leha on 23.02.17.
 */
public class ChinaBank extends Bank {
    @Override
    public int getLimitOfWithdrawal() {
        int retval = 0;
        if (currency == Currency.USD) retval = 100;
        if (currency == Currency.EUR) retval = 150;
        return retval;
    }
    @Override
    public int getLimitOfFunding() {
        int retval = 0;
        if (currency == Currency.USD) retval = 10000;
        if (currency == Currency.EUR) retval = 5000;
        return retval;
    }
    @Override
    public int getMonthlyRate() {
        int retval = 0;
        if (currency == Currency.USD) retval = 1;
        if (currency == Currency.EUR) retval = 0;
        return retval;
    }
    @Override
    public int getCommission(int summ) {
        int retval = 0;
        if (currency == Currency.USD)
            if (summ <= 1000) retval = 3;
            else retval = 5;
        if (currency == Currency.EUR)
            if (summ <= 1000) retval = 10;
            else retval = 11;
        return retval;
    }

    public ChinaBank(long id, String bankCountry, Currency currency, int numberOfEmployees, double avrSalaryOfEmployee, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployees, avrSalaryOfEmployee, rating, totalCapital);
    }
}
