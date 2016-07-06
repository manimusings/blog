package ctci.chap1;

import java.util.Arrays;

public class ReplaceSpaces {

  public static String compress(String str) {
    if (null == str || str.length() < 2) {
      return str;
    }

    StringBuffer compressed = new StringBuffer();
    char c = str.charAt(0);
    int count = 1;
    for (int i = 1; i < str.length(); ++i) {
      if (c == str.charAt(i)) {
        ++count;
      } else {
        compressed.append(c).append(count);
        c = str.charAt(i);
        count = 1;
      }
    }
    compressed.append(c).append(count);
    return compressed.length() < str.length() ? compressed.toString() : str;
  }

//  public static String compress2(String str) {
//    if (null == str || str.length() < 2) {
//      return str;
//    }
//
//    char[] compressed = new char[str.length()];
//    char c = str.charAt(0);
//    char count = 1;
//    int arraySize = 0;
//    for (int i = 1; i < str.length(); ++i) {
//      if (c == str.charAt(i)) {
//        ++count;
//      } else {
//        compressed[arraySize++] = c;
//        compressed[arraySize++] = count;
//        c = str.charAt(i);
//        count = 1;
//      }
//    }
//    compressed[arraySize++] = c;
//    compressed[arraySize++] = count;
//    compressed = Arrays.copyOf(compressed, arraySize);
//    return compressed.length < str.length() ? new String(compressed): str;
//  }

  public static void main(String[] args) {
    String s = "abcdeeeeffffgggaaaa";

    System.out.printf("%s=%s\n", s, compress(s));
//    System.out.printf("%s=%s\n", s, compress2(s));
  }
}
