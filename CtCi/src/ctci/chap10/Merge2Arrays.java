package ctci.chap10;

import java.util.Arrays;

public class Merge2Arrays {

    static int[] merge(int[] a, int lena, int b[]) {
        int i = lena - 1;
        int j = b.length - 1;
        while (j >= 0 && i >= 0) {
            if (a[i] >= b[j]) {
                a[i + j + 1] = a[i--];
//                System.out.println(Arrays.toString(a));
            } else {
                while (j >= 0 && b[j] > a[i]) {
                    a[i + j + 1] = b[j--];
//                    System.out.println(Arrays.toString(a));
                }
            }
        }
        while (j >= 0) {
            a[i + j + 1] = b[j--];
        }

        return a;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 0, 0, 0, 0, 0, 0};
        int[] b = {6, 7, 8, 9, 10};
        System.out.println("----------" + Arrays.toString(merge(a, 5, b)));

        int[] a1 = {6, 7, 8, 9, 10, 0, 0, 0, 0, 0, 0};
        int[] b1 = {1, 2, 3, 4, 5};
        System.out.println("**********" + Arrays.toString(merge(a1, 5, b1)));


        int[] a3 = {2, 5, 10, 13, 18, 0, 0, 0, 0, 0, 0};
        int[] b3 = {1, 3, 9, 11, 15, 17};
        System.out.println("+++++++++" + Arrays.toString(merge(a3, 5, b3)));

    }
}
