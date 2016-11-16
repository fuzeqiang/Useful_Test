package oj.test.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by fuzeqiang(100918) on 2016/10/13 0013.
 */
public class HappyNumber {

    public boolean isHappy(int n) {
        if (n < 1) {
            return false;
        }

        Set<Integer> set = new HashSet<Integer>();
        set.add(n);
        int sum = getSum(n);
        while (sum != 1) {
            System.out.println(sum);
            if (set.contains(sum)) {
                return false;
            }
            set.add(sum);
            sum = getSum(sum);
        }

        return true;
    }

    private int getSum(int n) {
        int sum = 0;
        while (n >= 10) {
            int temp = n % 10;
            sum += temp * temp;
            n /= 10;
        }
        sum += n * n;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(19));
    }

}
