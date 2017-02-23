package module4;

/**
 * Created by leha on 23.02.17.
 */
public class USBank extends Bank {
    @Override
    public int getLimitOfWithdrawal() {
        int retval = 0;
        if (currency == Currency.USD) retval = 2000;
        if (currency == Currency.EUR) retval = 2200;
        return retval;
    }
    @Override
    public int getLimitOfFunding() {
        int retval = 0;
        if (currency == Currency.USD) retval = 10000;
        if (currency == Currency.EUR) retval = 20000;
        return retval;
    }
    @Override
    public int getMonthlyRate() {
        int retval = 0;
        if (currency == Currency.USD) retval = 0;
        if (currency == Currency.EUR) retval = 1;
        return retval;
    }
    @Override
    public int getCommission(int summ) {
        int retval = 0;
        if (currency == Currency.USD)
            if (summ <= 1000) retval = 5;
            else retval = 7;
        if (currency == Currency.EUR)
            if (summ <= 1000) retval = 2;
            else retval = 4;
        return retval;
    }

    public USBank(long id, String bankCountry, Currency currency, int numberOfEmployees, double avrSalaryOfEmployee, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployees, avrSalaryOfEmployee, rating, totalCapital);
    }
}
