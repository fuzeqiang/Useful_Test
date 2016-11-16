package oj.test.contest.warm_up;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, return 1 - n in lexicographical order.
 * <p/>
 * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 * <p/>
 * Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
 */
public class LexicographicalNumbers {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> re = new ArrayList<Integer>(n);

        if (n < 10) {
            for (int i = 1; i <= n; i++) {
                re.add(i);
            }
            return re;
        }

        int firstNum;
        int digitNum = 0;
        int tempN = n;
        while (tempN >= 10) {
            tempN = tempN / 10;
            digitNum++;
        }
        firstNum = tempN;

        for (int i = 1; i <= 9; i++) {
            if (i < firstNum) {
                for (int j = 0; j <= digitNum; j++) {
                    int baseNum = (int) Math.pow(10, j);
                    int baseDigitNum = i * baseNum;

                    for (int k = 0; k < baseNum; k++) {
                        re.add(baseDigitNum++);
                    }
                }
            } else {
                for (int j = 0; j <= digitNum; j++) {
                    int baseNum = (int) Math.pow(10, j);
                    int baseDigitNum = i * baseNum;

                    if (j < digitNum) {
                        for (int k = 0; k < baseNum; k++) {
                            re.add(baseDigitNum++);
                        }
                    } else {
                        for (int k = 0; k < baseNum; k++) {
                            int temp = baseDigitNum++;
                            if (n >= temp) {
                                re.add(temp);
                            }
                        }
                    }
                }
            }//if...else
        }//for

        return re;
    }

    public static void main(String[] args) {
//        LexicographicalNumbers test = new LexicographicalNumbers();
//        for (int i = 0; i < 10; i++) {
//            long start = System.currentTimeMillis();
//            test.lexicalOrder(32);
//            System.out.println("time: " + (System.currentTimeMillis() - start));
//        }
//        long start = System.currentTimeMillis();
        System.out.println(new LexicographicalNumbers().lexicalOrder(37));
//        System.out.println("time: " + (System.currentTimeMillis() - start));
    }

}
