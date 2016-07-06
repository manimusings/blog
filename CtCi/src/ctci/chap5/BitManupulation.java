package ctci.chap5;

public class BitManupulation {

    static int exercise_5_1(int n, int m, int i, int j) {
//Step 1: if j = 6, then get to 11111100000
        int maskj = ~((1 << (j + 1)) - 1);
        System.out.println(Integer.toBinaryString(maskj));
        int maski = (1 << i) - 1;
        System.out.println(Integer.toBinaryString(maski));
        int maskij = maski | maskj;
        System.out.println(Integer.toBinaryString(maskij));
        int result = maskij & n;
        System.out.println(Integer.toBinaryString(result));
        result |= (m << i);
        System.out.println(Integer.toBinaryString(result));

        return result;
    }

    static long exercise_5_5(int a, int b) {
        System.out.printf("%d=%s\n", a, Integer.toBinaryString(a));
        System.out.printf("%d=%s\n", a - 1, Integer.toBinaryString(a - 1));
        System.out.printf("%d=%s\n", a & a - 1, Integer.toBinaryString(a & a - 1));
        System.out.printf("%d=%s\n", b, Integer.toBinaryString(b));
        int result = a ^ b;
        String resultStr = Integer.toBinaryString(result);
        System.out.printf("%d=%s\n", result, resultStr);

        return resultStr.chars().filter(c -> c == '1').count();
    }
//  static int fromBinaryString(String binary) {
//    char[] charArray = binary.toCharArray();
//    reverse(charArray);
//    System.out.println(new String(charArray));
//    int num = 0;
//    for (int i = 0; i < binary.length(); ++i) {
//      num += Math.pow(2, i) * (charArray[i] == '1' ? 1 : 0);
//    }
//    System.out.println(Integer.toBinaryString(num));
//    return num;
//  }
//
//  private static void reverse(char[] binary) {
//    int length = binary.length;
//    for (int i = 0; i < binary.length / 2; ++i) {
//      char tmp = binary[i];
//      binary[i] = binary[length - i - 1];
//      binary[length - i - 1] = tmp;
//    }
//  }

    public static void main_5_1(String[] args) {
        String nStr = "1010000000000";
        int i = 2;
        int j = 6;
        String mStr = "10011";
        int n = Integer.parseInt(nStr, 2);
        System.out.println(n);
        int m = Integer.parseInt(mStr, 2);
        System.out.println(m);
        System.out.println(exercise_5_1(n, m, i, j));
    }

    public static void main_5_3(String[] args) {
//    1111111111111111111111111111111
//    10000000000000000000000000000000
//    11111111111111111111111111101100
//    11111111111111111111111111111011
        System.out.println(Integer.toBinaryString(10));
        int i = 1;
        int lefti = i << 1;
        int righti = i >>> 1;
        System.out.printf("i=%d, left=%d, right=%d\n", i, lefti, righti);
        System.out
                .printf("i=%s, left=%s, right=%s\n", Integer.toBinaryString(i),
                        Integer.toBinaryString(lefti),
                        Integer.toBinaryString(righti));
    }


    public static void main(String[] args) {
        System.out.println(exercise_5_5(34, 14));
    }
}
