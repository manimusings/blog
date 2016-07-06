public class MatchingParens {

  public static boolean isBalanced(String target) {
    int startParen = 0;
    for (char c : target.toCharArray()) {
      if (c == '(') {
        ++startParen;
      } else if (c == ')') {
        if (startParen > 0) {
          --startParen;
        } else {
          return false;
        }
      }
    }
    return startParen == 0;
  }

  public static boolean isBalancedStream(CharSequence target ){

    target.chars().filter(ch->'('==ch || ')' == ch);

  }

  public static void main(String[] args) {
    String someString = "(1*(3/(1+1*(5+2))))";
    System.out.println(isBalanced(someString.toCharArray()));
    someString = "))((";
    System.out.println(isBalanced(someString.toCharArray()));
    someString = "abcd";
    System.out.println(isBalanced(someString.toCharArray()));
    someString = "(1+2*3()";
    System.out.println(isBalanced(someString.toCharArray()));
  }
}
