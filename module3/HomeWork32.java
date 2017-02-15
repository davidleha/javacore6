package module3;

/**
 * Created by leha on 14.02.17.
 */
public class HomeWork32 {
    public static void main(String[] args) {
        Integer a = new Integer(5);
        Integer b = new Integer(6);
        System.out.println(Adder.check(a, b));
        System.out.println(Adder.add(a, b));
    }
}

class Arithmetic {
    public static int add(Integer a, Integer b) {
       return a.intValue() + b.intValue();
    }
}

class Adder extends Arithmetic {
    public static boolean check(Integer a, Integer b) {
        if (a.intValue() >=  b.intValue())
            return true;
        else
            return false;
    }
}