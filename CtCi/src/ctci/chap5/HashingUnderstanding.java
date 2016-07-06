package ctci.chap5;

public class HashingUnderstanding {


    private static int hashThisCode(Object o) {
        int h = o.hashCode();
        int newH = h ^ (h >>> 16);
        System.out.printf("%s: old=%d, new=%d\n", o, newH);
        return newH;
    }

    public static void main(String[] args) {
//        System.out.println(exercise_5_5(34, 14));
        Integer i = (int)Math.pow(2, 17) + 1;
        Integer j = (int)Math.pow(2, 18) + 1;
//        System.out.printf("i=%d, j=%d\n", i.hashCode(), j.hashCode());
        int hi, hj;
        for (int k = 3; k < 100; k = k + 2) {
            hi = hashThisCode(i);
            hj = hashThisCode(j);
            if ((hi & k) == (hj & k)) {
                System.out.printf("%d: i=%d,j=%d,hi=%d,hj=%d,hashi=%d,hashj=%d\n", k, i, j, hi, hj, hi & k, hj & k);
            }
        }

    }
}
