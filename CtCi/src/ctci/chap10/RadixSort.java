package ctci.chap10;

import java.util.Arrays;

public class RadixSort {

    static int[] radixSort(int[] a) {
        for (int i = 1; i > 0; i = i << 1) {
            for (int j = 0; j < a.length - 1; ++j) {
                System.out.printf("\ni=%s, j=%s,a[j]=%s, a[j] & i=%s",
                        Integer.toBinaryString(i), j, Integer.toBinaryString(a[j]), a[j] & i);
                if ((a[j] & i) != 0) {
                    swap(a, j, j + 1);
                }
                System.out.printf("\na=%s", Arrays.toString(a));
            }
        }
        return a;
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] b3 = {1, 0, 91, 3, 115, 17};
        System.out.println(Arrays.toString(radixSort(b3)));
    }
}
