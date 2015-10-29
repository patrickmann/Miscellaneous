import java.util.Arrays;

/**
 * Given a number as an int array, return an array that represents that number + 1.
 * E.g. {1,2,3} --> {1,2,4}
 * - do not generate leading 0
 * - negative numbers are denoted by a boolean flag
 * - zero can be negative or positive
 * - assume input has no leading zeroes
 */
public class LongAddition {
    public static int[] add(int[] num, boolean neg) {
        if (null == num || 0 == num.length) return null;

        // 999... + 1 special case
        if (!neg && allEqual(num, 9)) {
            int[] newArray = new int[num.length + 1];
            newArray[0] = 1;
            for (int i = 1; i < newArray.length; i++)
                newArray[i] = 0;
            return newArray;
        }

        // -000... - 1 special case
        if (neg && allEqual(num, 0)) {
            return new int[]{1};
        }

        int carry = neg ? -1 : 1;
        for (int i = num.length - 1; i >= 0; i--) {
            carry = addDigit(num, i, carry, neg);
        }

        // remove leading 0, unless the result is actually 0
        if (num[0] == 0 && num.length > 1) {
            int[] newArray = new int[num.length - 1];
            for (int i = 1; i < num.length; i++)
                newArray[i-1] = num[i];
            return newArray;
        }

        return num;
    }

    // Compare all digits with given value
    private static boolean allEqual(int[] num, int value) {
        for (int d : num) {
            if (d != value)
                return false;
        }
        return true;
    }

    // Increment/decrement a single digit with carry
    // Return new carry
    private static int addDigit(int[] num, int index, int carry, boolean neg) {
        int sum = num[index] + carry;
        if (!neg && sum > 9) {    //9+1=0 carry 1
            num[index] = 0;
        } else if (neg && sum < 0) { //0-1=9 borrow 1
            num[index] = 9;
        } else {                  //no carry or borrow
            num[index] = sum;
            carry = 0;
        }
        return carry;
    }

    public static void test(int[] num, boolean neg) {
        // LongAddition() modifies in place, so evaluate original values first
        int sum1 = sumArray(num, neg);
        String str1 = Arrays.toString(num);
        int[] result = LongAddition.add(num, neg);
        int sum2 = sumArray(result, (sum1==0)?false:neg);
        if ((sum2 - sum1) != 1)
            System.out.print("FAIL ");
        else
            System.out.print("PASS ");
        System.out.println((neg ? "-" : " ") + str1 + " " + Arrays.toString(result));
    }

    private static int sumArray(int[] num, boolean neg) {
        int sum = 0;
        for (int d : num) {
            sum = sum*10 + d;
        }
        return (neg ? sum * -1 : sum);
    }
}
