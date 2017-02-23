package module4;

/**
 * Created by leha on 23.02.17.
 */
public class EUBank extends Bank {
    @Override
    public int getLimitOfWithdrawal() {
        int retval = 0;
        if (currency == Currency.USD) retval = 1000;
        if (currency == Currency.EUR) retval = 1200;
        return retval;
    }
    @Override
    public int getLimitOfFunding() {
        int retval = 0;
        if (currency == Currency.USD) retval = Integer.MAX_VALUE; // without limit;
        if (currency == Currency.EUR) retval = 10000;
        return retval;
    }
    @Override
    public int getMonthlyRate() {
        int retval = 0;
        if (currency == Currency.USD) retval = 1;
        if (currency == Currency.EUR) retval = 2;
        return retval;
    }
    @Override
    public int getCommission(int summ) {
        int retval = 0;
        if (currency == Currency.USD)
            if (summ <= 1000) retval = 5;
            else retval = 7;
        if (currency == Currency.EUR)
            if (summ <= 1000) retval = 6;
            else retval = 8;
        return retval;
    }
    public EUBank(long id, String bankCountry, Currency currency, int numberOfEmployees, double avrSalaryOfEmployee, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployees, avrSalaryOfEmployee, rating, totalCapital);
    }
}
