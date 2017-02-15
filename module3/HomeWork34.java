package module3;

public class HomeWork34 {
    public static void main(String[] args) {
        User user1 = new User("Simon Cat", 1500, 10, "Roga i Kopita", 500, "$");
        System.out.println("User " + user1.getName());
        System.out.println("Salary: " + user1.getSalary());
        System.out.println("Balance: " + user1.getBalance() + user1.getCurrency());
        System.out.println("next month");
        user1.paySalary();
        user1.monthIncreaser(1);
        System.out.println("Balance: " + user1.getBalance() + user1.getCurrency());
        System.out.println("withdraw 999$");
        user1.withdraw(999);
        System.out.println("Balance: " + user1.getBalance() + user1.getCurrency());
    }
}

class User {
    private String name;
    private int balance;
    private int monthOfEmployment;
    private String companyName;
    private int salary;
    private String currency;

    public User(String name, int balance, int monthOfEmployment, String companyName, int salary, String currency) {
        this.name = name;
        this.balance = balance;
        this.monthOfEmployment = monthOfEmployment;
        this.companyName = companyName;
        this.salary = salary;
        this.currency = currency;
    }

    public void paySalary() {
        balance += salary;
    }

    public void withdraw(int summ) {
        if (summ < 1000)
            balance -= summ * 1.05;
        else
            balance -= summ * 1.1;
    }

    public int companyNameLength() {
        return companyName.length();
    }

    public void monthIncreaser(int addMonth) {
        monthOfEmployment += addMonth;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getMonthOfEmployment() {
        return monthOfEmployment;
    }

    public void setMonthOfEmployment(int monthOfEmployment) {
        this.monthOfEmployment = monthOfEmployment;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}