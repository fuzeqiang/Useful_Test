package oj.test.easy;

/**
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
 * <br/>
 * Given n, find the total number of full staircase rows that can be formed.
 * <br/>
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 * <p/>
 * <pre>
 * Example 1:
 * n = 5
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * Because the 3rd row is incomplete, we return 2.
 *
 * Example 2:
 * n = 8
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * Because the 4th row is incomplete, we return 3.
 * </pre>
 */
public class ArrangingCoins {
    public static final double sqrt2 = Math.sqrt(2);

    public int arrangeCoins(int n) {
        int re = (int) (sqrt2 * Math.sqrt(n));
        int sum;
        if (0 == re % 2) {
            sum = (1 + re) * (re >> 1);
        } else {
            sum = ((1 + re) >> 1) * re;
        }

        if (sum > n) {
            return re - 1;
        }
        return re;
    }

    public static void main(String[] args) {
        ArrangingCoins test = new ArrangingCoins();
//        test.arrangeCoins(2147483647);
//        int n = 65535;
//        System.out.println((1 + n) * (n / 2));
        System.out.println(test.arrangeCoins(5));
    }
}
