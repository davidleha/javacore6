package module3;

public class HomeWork31 {
    public static void main(String[] args) {
        Bird bird1 = new Bird("Ch'punja");
        bird1.sing();
        bird1.walk();
        bird1.fly();
        Bird bird2 = new Bird();
        bird2.sing();
        bird2.walk();
        bird2.fly();
    }
}

class Bird {
    private final String actSing = "I am singing";
    private final String actWalk = "I am walking";
    private final String actFly = "I am flying";
    private final String actIntro = "I am Bird";
    private String name;

    public Bird() {
        this.name = "noname";
        System.out.println(actIntro);
    }

    public Bird(String name) {
        this.name = name;
        System.out.println(actIntro + ", my name is " + this.name );
    }

    public void sing() {
        System.out.println(actSing);
    }

    public void walk() {
        System.out.println(actWalk);
    }

    public void fly() {
        System.out.println(actFly);
    }
}