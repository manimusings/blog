public class Main {

  /**
   * Applies a supplemental hash function to a given hashCode, which
   * defends against poor quality hash functions.  This is critical
   * because HashMap uses power-of-two length hash tables, that
   * otherwise encounter collisions for hashCodes that do not differ
   * in lower bits. Note: Null keys always map to hash 0, thus index 0.
   */
  static int hash(int h) {
    // This function ensures that hashCodes that differ only by
    // constant multiples at each bit position have a bounded
    // number of collisions (approximately 8 at default load factor).
    System.out.printf("\nh=%s", Integer.toBinaryString(h));
    System.out.printf("\nh >>> 20=%s", Integer.toBinaryString(h >>> 20));
    System.out.printf("\nh >>> 12=%s", Integer.toBinaryString(h >>> 12));

    h ^= (h >>> 20) ^ (h >>> 12);
    System.out.printf("\nh ^= (h >>> 20) ^ (h >>> 12)=%s", Integer.toBinaryString(h));
    System.out.printf("\nh >>> 7=%s", Integer.toBinaryString(h >>> 7));
    System.out.printf("\nh >>> 4=%s", Integer.toBinaryString(h >>> 4));
    int result = h ^ (h >>> 7) ^ (h >>> 4);
    System.out.printf("\nh ^= (h >>> 7) ^ (h >>> 4)=%s", Integer.toBinaryString(h));
    return result;
  }

  /**
   * Returns index for hash code h.
   */
  static int indexFor(int h, int length) {
    return h & (length - 1);
  }

  static int indexForNonPower2(int h, int length) {
    return h % length;
  }

  public static void main(String[] args) {
    Integer key = 50;
    Integer[] table = new Integer[32];
    int h = key.hashCode();
    int hash = hash(h);
    int i = indexFor(hash, table.length);
    int j = indexForNonPower2(hash, table.length);
    System.out.printf("\nhash=%d, table.length=%d, i=%d, j=%d", hash, table.length, i, j);
    System.out.printf("\nh=%d[%s], (length-1)=%d[%s], h %% length=%d, h & (length-1)=%d",
                      hash, Integer.toBinaryString(hash), table.length - 1,
                      Integer.toBinaryString(table.length - 1), (hash % table.length),
                      (hash & (table.length - 1)));
    System.out.printf("\nval=%d, po2=%d \n", 1 << 30, (int)Math.pow(2, 30));
    System.out.println(Integer.MAX_VALUE);
  }
}
