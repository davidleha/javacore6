package module4;

/**
 * Created by leha on 24.02.17.
 */
public class Main {
    public static void main(String[] args) {
        BankSystemImpl bs = new BankSystemImpl();
        USBank bank1 = new USBank(2525, "Ukraine", Currency.USD, 120, 510.2D, 5000, 250000000);
        EUBank bank2 = new EUBank(2535, "Ukraine", Currency.USD, 90, 610.2D, 5000, 150000000);
        ChinaBank bank3 = new ChinaBank(2233, "Russia", Currency.EUR, 100, 410.2D, 4200, 150000000);
        User[] users = {
            new User(2001, "Фаина Пробка", 500, 10, "LPVC", 300, bank1),
            new User(2002, "Фаина Дратва", 100, 2, "LPVC", 300, bank1),
            new User( 2003, "Вера Мебель", 1500, 10, "LPVC", 500, bank2),
            new User(2001, "Сима Маховик", 2500, 8, "LPVC", 600, bank2),
            new User(2001, "Мотя Нафталин", 100, 30, "VW", 1300, bank3),
            new User(2001, "Песя Шлагбаум", 5500, 30, "VW", 1300, bank3),
        };
        printUsers(users);
        System.out.println("All users has funded their bank 100 currency");
        for (User u : users) bs.fundUser(u, 100);
        printUsers(users);
        System.out.println("All users received salary");
        for (User u : users) bs.paySalary(u);
        printUsers(users);
        System.out.println("All users withdrawed 1000 currency");
        for (User u : users) bs.withdrawOfUser(u,1000);
        printUsers(users);
        System.out.println("First user recieved 100 identical currency from other users");
        for (User u : users) bs.transferMoney(u, users[0], 100);
        printUsers(users);
    }

    static void printUsers(User users[]) {
        for (User u : users) System.out.println(u);
        System.out.println();
    }
}
