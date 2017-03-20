package module6;

public class ArraysMain {
    public static void main(String[] args) {
        int iarr[] = new int[] { 1, -2, 3, -4, 5, -6, 7, -8, 9, -10 };
        System.out.println("Original array:");
        for (int i = 0; i < 10; i++)
            System.out.println(iarr[i]);
        System.out.println(" ");
        System.out.println("sum = " + ArraysUtils.sum(iarr));
        System.out.println("min = " + ArraysUtils.min(iarr));
        System.out.println("max = " + ArraysUtils.max(iarr));
        System.out.println("maxPositive = " + ArraysUtils.maxPositive(iarr));
        System.out.println("multiplication = " + ArraysUtils.multiplication(iarr));
        System.out.println("modulus = " + ArraysUtils.modulus(iarr));
        System.out.println("secondLargest = " + ArraysUtils.secondLargest(iarr));
        System.out.println("reversed array: ");
        int a[] = ArraysUtils.reverse(iarr);
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);
        System.out.println("even elements of array:");
        a = ArraysUtils.findEvenElements(iarr);
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);
    }

}

final class ArraysUtils {
    private ArraysUtils() {}

    public static int sum(int arr[]) {
        int res = 0;
        for (int i = 0; i < arr.length; i++)
            res += arr[i];
        return res;
    }

    public static int min(int arr[]) {
        int res = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < res)
                res = arr[i];
        }
        return res;
    }

    public static int max(int arr[]) {
        int res = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > res)
                res = arr[i];
        }
        return res;
    }

    public static int maxPositive(int arr[]) {
        int res = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0 && arr[i] > res)
                res = arr[i];
        }
        return res;
    }

    public static int multiplication(int arr[]) {
        int mult = 1;
        for (int i = 0; i < arr.length; i++)
            mult *= arr[i];
        return mult;
    }

    public static int modulus(int arr[]) {
        int first = arr[0];
        int last = arr[arr.length - 1];
        if (first < 0) first *= -1;
        if (last < 0) last *= -1;
        return first + last;
    }

    public static int secondLargest(int arr[]) {
        int largest = max(arr);
        int res = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > res && arr[i] < largest)
                res = arr[i];
        }
        return res;
    }

    public static int[] reverse(int[] arr) {
        int len = arr.length;
        int resArr[] = new int[len];
        for (int i = 0; i < len; i++)
            resArr[len-i-1] = arr[i];
        return resArr;
    }

    public static int[] findEvenElements(int[] arr) {
        int evenEl = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] % 2 == 0) evenEl++;
        if (evenEl == 0) return null;
        int resArr[] = new int[evenEl];
        int ii = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] % 2 == 0) resArr[ii++] = arr[i];
        return resArr;
    }
}
