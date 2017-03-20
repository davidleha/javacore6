package module6;

public class UsersMain {
    public static void main(String[] args) {
        User tmpUsers[];
        User users[] = {
                new User(100, "Фаина", "Пробка", 400, 2000),
                new User(101, "Фаина", "Дратва", 300, 2000),
                new User(100, "Фаина", "Пробка", 400, 2000),
                new User(102, "Вера", "Мебель", 300, 2000),
                new User(103, "Сима", "Маховик", 400, 800),
                new User(104, "Мотя", "Нафталин", 400, 1200),
                new User(104, "Мотя", "Нафталин", 400, 1200)
        };
        System.out.println("Original array:");
        module5.Main.printArray(users, true);

        System.out.println("unique users:");
        users = UserUtils.uniqueUsers(users);
        module5.Main.printArray(users, true);

        System.out.println("users with 2000 balance");
        tmpUsers = UserUtils.usersWithConditionalBalance(users, 2000);
        module5.Main.printArray(tmpUsers, true);

        System.out.println("после зарплаты:");
        users = UserUtils.paySalaryToUsers(users);
        module5.Main.printArray(users, true);

        System.out.println("user's IDs:");
        long[] ids = UserUtils.getUsersId(users);
        for (int i = 0; i < ids.length; i++) System.out.println(ids[i]);
        System.out.println();

        System.out.println("array after deleting null elements:");
        users = UserUtils.deleteEmptyUsers(users);
        module5.Main.printArray(users, true);
    }
}

class UserUtils {
    private UserUtils() {
    }

    public static User[] uniqueUsers(User[] users) {
        int len = users.length;
        User[] resArr = new User[len];
        for (int i = 0; i < len; i++) resArr[i] = users[i];
        for (int i = 0; i < len - 1; i++) {
            if (resArr[i] == null) continue;
            for (int ii = i + 1; ii < len; ii++)
                if (resArr[i].equals(resArr[ii])) resArr[ii] = null;
        }
        return resArr;
    }

    public static User[] usersWithConditionalBalance(User[] users, int balance) {
        int len = users.length;
        User[] resArr = new User[len];
        for (int i = 0; i < len; i++) resArr[i] = users[i];
        for (int i = 0; i < len; i++) {
            if (resArr[i] == null) continue;
            if (resArr[i].getBalance() != balance) resArr[i] = null;
        }
        return resArr;
    }

    public static final User[] paySalaryToUsers(User[] users) {
        int len = users.length;
        User resArr[] = new User[len];
        for (int i = 0; i < len; i++) {
            if (users[i] == null) continue;
            resArr[i] = new User(users[i].getId(),
                    users[i].getFirstName(),
                    users[i].getLastName(),
                    users[i].getSalary(),
                    users[i].getBalance() + users[i].getSalary());
        }
        return resArr;
    }

    public static final long[] getUsersId(User[] users) {
        long resArr[] = new long[users.length];
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) continue;
            resArr[i] = users[i].getId();
        }
        return resArr;
    }

    public static User[] deleteEmptyUsers(User[] users) {
        int n = 0;
        for (int i = 0; i < users.length; i++)
            if (users[i] == null) ++n;
        n = users.length - n;
        User resArr[] = new User[n];
        n = 0;
        for (int i = 0; i < users.length; i++)
            if (users[i] != null) resArr[n++] = users[i];
        return resArr;
    }
}


