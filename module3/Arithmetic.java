package module3;

public class Arithmetic {
    public static int add(Integer a, Integer b) {
        return a.intValue() + b.intValue();
    }

    public static void main(String[] args) {
        Integer a = new Integer(5);
        Integer b = new Integer(6);
        System.out.println(Adder.check(a, b));
        System.out.println(Adder.add(a, b));
    }
}

class Adder extends Arithmetic {
    public static boolean check(Integer a, Integer b) {
        return a.intValue() >=  b.intValue();
    }
}
