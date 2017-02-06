package module2;

import java.util.*;

public class HomeWork_21 {

    public static void main(String[] args) {

        int iarr[] = new int[10];
        double darr[] = new double[10];

        Random r = new Random();

        for (int i = 0; i < 10; i++) {
            iarr[i] = r.nextInt();
            darr[i] = r.nextFloat() * iarr[i] / 100000;
        }

        for(int i = 0; i < 10; i++)
            System.out.println(iarr[i]);

        System.out.println(" ");

        for(int i = 0; i < 10; i++) {
            System.out.println(darr[i]);
        }

        System.out.println(" ");

        System.out.println("sum_int = " + sum(iarr));
        System.out.println("sum_double = " + sum(darr));

        System.out.println("min_int = " + min(iarr));
        System.out.println("min_double = " + min(darr));

        System.out.println("max_int = " + max(iarr));
        System.out.println("max_double = " + max(darr));

        System.out.println("maxPositive_int = " + maxPositive(iarr));
        System.out.println("maxPositive_double = " + maxPositive(darr));

        System.out.println("multiplication_int = " + multiplication(iarr));
        System.out.println("multiplication_double = " + multiplication(darr));

        System.out.println("modulus_int = " + modulus(iarr));
        System.out.println("modulus_double = " + modulus(darr));

        System.out.println("secondLargest_int = " + secondLargest(iarr));
        System.out.println("secondLargest_double = " + secondLargest(darr));

    }

    // ------------------------------------------
    static int sum(int arr[]) {
        int res = 0;
        for (int i = 0; i < arr.length; i++)
            res += arr[i];
        return res;
    }

    static double sum(double arr[]) {
        double res = 0;
        for (int i = 0; i < arr.length; i++)
            res += arr[i];
        return res;
    }

    // ------------------------------------------
    static int min(int arr[])
    {
        int res = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < res)
                res = arr[i];
        }
        return res;
    }

    static double min(double arr[]) {
        double res = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < res)
                res = arr[i];
        }
        return res;
    }

    // ------------------------------------------
    static int max(int arr[]) {
        int res = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > res)
                res = arr[i];
        }
        return res;
    }

    static double max(double arr[]) {
        double res = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > res)
                res = arr[i];
        }
        return res;
    }

    // ------------------------------------------
    static int maxPositive(int arr[]) {
        int res = arr[0];
        for (int i = 0; i < arr.length; i++) {
           if (arr[i] > 0 && arr[i] > res)
               res = arr[i];
        }
        return res;
    }

    static double maxPositive(double arr[]) {
        double res = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0 && arr[i] > res)
                res = arr[i];
        }
        return res;
    }

    // ------------------------------------------
    static int multiplication(int arr[]) {
        int mult = 1;
        for (int i = 0; i < arr.length; i++)
            mult *= arr[i];
        return mult;
    }

    static double multiplication(double arr[]) {
        double mult = 1;
        for (int i = 0; i < arr.length; i++)
            mult *= arr[i];
        return mult;
    }

    // ------------------------------------------
    static int modulus (int arr[]) {
        int first = arr[0];
        int last = arr[arr.length-1];
        if (first < 0) first *= -1;
        if (last < 0) last *= -1;
        return first + last;
    }

    static double modulus (double arr[]) {
        double first = arr[0];
        double last = arr[arr.length-1];
        if (first < 0) first *= -1;
        if (last < 0) last *= -1;
        return first + last;
    }

    // ------------------------------------------
    static int secondLargest(int arr[]) {
        int largest = max(arr);
        int res = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > res && arr[i] < largest)
                res = arr[i];
        }
        return res;
    }

    static double secondLargest(double arr[]) {
        double largest = max(arr);
        double res = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > res && arr[i] < largest)
                res = arr[i];
        }
        return res;
    }
}