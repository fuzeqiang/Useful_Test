package oj.test.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * <p/>
 * For example, given numRows = 5,
 * Return
 * <pre>
 * [
 *            [1],
 *           [1,1],
 *          [1,2,1],
 *         [1,3,3,1],
 *        [1,4,6,4,1]
 * ]
 * </pre>
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> re = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (0 == j || i == j) {
                    row.add(1);
                } else {
                    List<Integer> lastRow = re.get(i - 1);
                    row.add(lastRow.get(j - 1) + lastRow.get(j));
                }
            }
            re.add(row);
        }
        return re;
    }

    public static void main(String[] args) {
        List<List<Integer>> re = new PascalTriangle().generate(6);
        for (List<Integer> list : re) {
            System.out.println(list);
        }
    }
}
