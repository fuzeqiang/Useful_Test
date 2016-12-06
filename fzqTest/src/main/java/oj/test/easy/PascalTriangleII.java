package oj.test.easy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * <br/>
 * For example, given k = 3,
 * Return [1,3,3,1].
 * <p/>
 * Note: Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalTriangleII {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> re = new ArrayList<Integer>();
        re.add(1);
        if (0 == rowIndex) {
            return re;
        }
        int half = rowIndex / 2 + 1;
        for (int i = 2; i <= half; i ++) {
            int num = getCombination(rowIndex, i - 1);
            re.add(num);
        }
        if (0 == rowIndex % 2) {
            half--;
        }
        for (int i = half - 1; i >= 0; i--) {
            re.add(re.get(i));
        }

        return re;
    }

    private int getCombination(int n, int m) {
        if (0 == m) {
            return 1;
        }

        BigDecimal bd = new BigDecimal("" + n);

        int j = m;
        for (int i = n - 1; i >= n - m + 1; i--) {
            bd = bd.multiply(new BigDecimal("" + i));
        }

        for (int i = 2; i <=m; i++) {
            bd = bd.divide(new BigDecimal("" + i));
        }

        return bd.intValue();
    }

    public static void main(String[] args) {
        System.out.println(new PascalTriangleII().getRow(31));
    }

}
