package module3;

/**
 * Created by leha on 16.02.17.
 */
public class Bird {
    private final static String WORDS_1 = "I am singing";
    private final static String WORDS_2  = "I am walking";
    private final static String WORDS_3 = "I am flying";
    private final static String WORDS_4 = "I am Bird";
    private String name;

    public Bird() {}

    public Bird(String name) {
        this.name = name;
    }

    public void sing(String s) {
        if (name != null)
            System.out.print(name + ": ");
        System.out.println(s);
    }

    public static void main(String[] args) {
        Bird bird1 = new Bird("Elisa");
        Bird bird2 = new Bird();
        bird1.sing(WORDS_1);
        bird1.sing(WORDS_2);
        bird1.sing(WORDS_3);
        bird1.sing(WORDS_4);
        bird2.sing(WORDS_1);
        bird2.sing(WORDS_2);
        bird2.sing(WORDS_3);
        bird2.sing(WORDS_4);
    }
}

