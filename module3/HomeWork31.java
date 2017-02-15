package module3;

public class HomeWork31 {
    public static void main(String[] args) {
        Bird aloneTitmouse = new Bird();
        aloneTitmouse.sing();
        aloneTitmouse.walk();
        aloneTitmouse.fly();
    }
}

class Bird {
    public Bird() {
        System.out.println("I am Bird");
    }

    public void sing() {
        System.out.println("I am singing");
    }

    public void walk() {
        System.out.println("I am walking");
    }

    public void fly() {
        System.out.println("I am flying");
    }
}