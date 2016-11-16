package oj.test.easy;

/**
 * Given two non-negative numbers num1 and num2 represented as string, return the sum of num1 and num2.
 * <p/>
 * Note:
 * <br/>
 * The length of both num1 and num2 is < 5100.<br/>
 * Both num1 and num2 contains only digits 0-9.<br/>
 * Both num1 and num2 does not contain any leading zero.<br/>
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class AddStrings {

    public String addStrings(String num1, String num2) {
        int length = num1.length() >= num2.length() ? num1.length() : num2.length();
        int[] arr1 = new int[length];
        int[] arr2 = new int[length];
        String re = "";

        insertNum2Arr(arr1, num1);
        insertNum2Arr(arr2, num2);

        int carry = 0;
        for (int i = 0; i < length; i++) {
            int sum = arr1[i] + arr2[i] + carry;
            carry = sum / 10;
            re = (sum % 10) + re;
        }

        if (carry > 0) {
            re = carry + re;
        }

        return re;
    }

    private void insertNum2Arr(int[] arr, String num) {
        int length = num.length();
        int count = 0;
        for (int i = length - 1; i >= 0; i--) {
            arr[count++] = num.charAt(i) - '0';
        }
    }

    public static void main(String[] args) {
        System.out.println(new AddStrings().addStrings("0", "0"));
//        System.out.println('9' - '0');
    }

}
