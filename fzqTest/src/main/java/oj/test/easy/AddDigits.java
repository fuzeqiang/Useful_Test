package oj.test.easy;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * <p/>
 * For example:
 * <p/>
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 */
public class AddDigits {

    public static int addDigits(int num) {
        int sum = 0;
        while (10 <= num) {
            sum += num % 10;
            num = num / 10;
        }
        sum += num;

        if (10 <= sum) {
            return addDigits(sum);
        } else {
            return sum;
        }
    }

    public int addDigits2(int num) {
        return (num - 1) % 9 + 1;
    }

    public static void main(String[] args) {
        AddDigits ad = new AddDigits();
        for (int i = 0; i < 20; i++) {
            System.out.println(i + "  " + ad.addDigits2(i));
        }
        System.out.println(addDigits(555));
    }

}
