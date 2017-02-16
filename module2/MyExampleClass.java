package module2;

public class MyExampleClass {

    public static void main(String[] args) {
        int iarr[] = new int[] { 1, -2, 3, -4, 5, -6, 7, -8, 9, -10 };
        double darr[] = new double[] { -0.1, -0.2, -0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0 };

        for (int i = 0; i < 10; i++)
            System.out.println(iarr[i]);
        System.out.println(" ");
        for (int i = 0; i < 10; i++) {
            System.out.println(darr[i]);
        }
        System.out.println(" ");

        MyExampleClass myClass = new MyExampleClass();

        System.out.println("sum_int = " + myClass.sum(iarr));
        System.out.println("sum_double = " + myClass.sum(darr));

        System.out.println("min_int = " + myClass.min(iarr));
        System.out.println("min_double = " + myClass.min(darr));

        System.out.println("max_int = " + myClass.max(iarr));
        System.out.println("max_double = " + myClass.max(darr));

        System.out.println("maxPositive_int = " + myClass.maxPositive(iarr));
        System.out.println("maxPositive_double = " + myClass.maxPositive(darr));

        System.out.println("multiplication_int = " + myClass.multiplication(iarr));
        System.out.println("multiplication_double = " + myClass.multiplication(darr));

        System.out.println("modulus_int = " + myClass.modulus(iarr));
        System.out.println("modulus_double = " + myClass.modulus(darr));

        System.out.println("secondLargest_int = " + myClass.secondLargest(iarr));
        System.out.println("secondLargest_double = " + myClass.secondLargest(darr));

    }

    public  int sum(int arr[]) {
        int res = 0;
        for (int i = 0; i < arr.length; i++)
            res += arr[i];
        return res;
    }

    public  double sum(double arr[]) {
        double res = 0;
        for (int i = 0; i < arr.length; i++)
            res += arr[i];
        return res;
    }

    public  int min(int arr[]) {
        int res = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < res)
                res = arr[i];
        }
        return res;
    }

    public  double min(double arr[]) {
        double res = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < res)
                res = arr[i];
        }
        return res;
    }

    public  int max(int arr[]) {
        int res = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > res)
                res = arr[i];
        }
        return res;
    }

    public  double max(double arr[]) {
        double res = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > res)
                res = arr[i];
        }
        return res;
    }

    public  int maxPositive(int arr[]) {
        int res = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0 && arr[i] > res)
                res = arr[i];
        }
        return res;
    }

    public  double maxPositive(double arr[]) {
        double res = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0 && arr[i] > res)
                res = arr[i];
        }
        return res;
    }

    public  int multiplication(int arr[]) {
        int mult = 1;
        for (int i = 0; i < arr.length; i++)
            mult *= arr[i];
        return mult;
    }

    public  double multiplication(double arr[]) {
        double mult = 1;
        for (int i = 0; i < arr.length; i++)
            mult *= arr[i];
        return mult;
    }

    public  int modulus(int arr[]) {
        int first = arr[0];
        int last = arr[arr.length - 1];
        if (first < 0) first *= -1;
        if (last < 0) last *= -1;
        return first + last;
    }

    public  double modulus(double arr[]) {
        double first = arr[0];
        double last = arr[arr.length - 1];
        if (first < 0) first *= -1;
        if (last < 0) last *= -1;
        return first + last;
    }

    public  int secondLargest(int arr[]) {
        int largest = max(arr);
        int res = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > res && arr[i] < largest)
                res = arr[i];
        }
        return res;
    }

    public  double secondLargest(double arr[]) {
        double largest = max(arr);
        double res = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > res && arr[i] < largest)
                res = arr[i];
        }
        return res;
    }
}