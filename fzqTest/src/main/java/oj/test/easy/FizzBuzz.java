package oj.test.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a program that outputs the string representation of numbers from 1 to n.
 * <br/>
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”.
 * <br/>
 * For numbers which are multiples of both three and five output “FizzBuzz”.
 * <p/>
 * Example:
 * <br/>
 * n = 15,
 * <br/>
 * Return:
 * [
 * "1",
 * "2",
 * "Fizz",
 * "4",
 * "Buzz",
 * "Fizz",
 * "7",
 * "8",
 * "Fizz",
 * "Buzz",
 * "11",
 * "Fizz",
 * "13",
 * "14",
 * "FizzBuzz"
 * ]
 */
public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> re = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            boolean isMultiplesOf3 = 0 == i % 3;
            boolean isMultiplesOf5 = 0 == i % 5;
            if (isMultiplesOf3 || isMultiplesOf5) {
                if (isMultiplesOf3) {
                    if (isMultiplesOf5) {
                        re.add("FizzBuzz");
                    } else {
                        re.add("Fizz");
                    }
                } else {
                    re.add("Buzz");
                }
            } else {
                re.add("" + i);
            }
        }
        return re;
    }

}
