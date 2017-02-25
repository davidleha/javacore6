package module3;

public class Arithmetic {
    public static int add(Integer a, Integer b) {
        return a + b;
    }

    public static void main(String[] args) {
        Integer a = 5;
        Integer b = 6;
        System.out.println(Adder.check(a, b));
        System.out.println(Adder.add(a, b));
    }
}

class Adder extends Arithmetic {
    public static boolean check(Integer a, Integer b) {
        return a >=  b;
    }
}
