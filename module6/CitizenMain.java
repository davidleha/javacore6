package module6;

public class CitizenMain {
    public static void main(String[] args) {
        Citizen citizens[] = new Citizen[4];
        citizens[0] = CitizenFactory.getEnglishman();
        citizens[1] = CitizenFactory.getChinese();
        citizens[2] = CitizenFactory.getRussian();
        citizens[3] = CitizenFactory.getItalian();
        for (int i = 0; i < citizens.length; i++) citizens[i].sayHello();
    }
}

interface Citizen {
    void sayHello();
}

class CitizenFactory {
    private static class Englishman implements Citizen {
        public void sayHello() {
            System.out.println("Hello!");
        }
    }

    private static class Chinese implements Citizen {
        public void sayHello() {
            System.out.println("nǐ hǎo");
        }
    }

    private static class Russian implements Citizen {
        public void sayHello() {
            System.out.println("Привет!");
        }
    }

    private static class Italian implements Citizen {
        public void sayHello() {
            System.out.println("Ciao!");
        }
    }

    public static Citizen getEnglishman() { return new Englishman(); }
    public static Citizen getChinese() { return new Chinese(); }
    public static Citizen getRussian() { return new Russian(); }
    public static Citizen getItalian() { return new Italian(); }

}