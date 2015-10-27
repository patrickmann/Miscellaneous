/**
 * Given a number as an int array, return an array that represents that number + 1.
 * E.g. {1,2,3} --> {1,2,4}
 * - do not generate leading 0
 * - negative numbers are denoted by a boolean flag
 */
public class LongAddition {
    public static int[] add (int[] num, boolean neg) {
        if (null == num || 0 == num.length) return null;

        // all 9s special case
        if (!neg && allEqual(num, 9)) {
            int[] newArray = new int[num.length+1];
            newArray[0] = 1;
            for (int i=1; i<newArray.length; i++)
                newArray[i] = 0;
            return newArray;
        }

        // all 0s special case
        if (neg && allEqual(num, 0)) {
            int[] newArray = new int[Math.max(num.length-1, 1)];
            for (int i=0; i<newArray.length; i++)
                newArray[i] = 1;
            return newArray;
        }

        int carry = neg ? -1 : 1;
        for (int i = num.length-1; i >= 0; i--) {
            carry = addDigit(num, i, carry, neg);
        }
        return num;
    }

    private static boolean allEqual (int[] num, int value) {
        for (int d: num) {
            if (d != value)
                return false;
        }
        return true;
    }

    private static int addDigit (int[] num, int index, int carry, boolean neg) {
        int sum = num[index] + carry;
        if (!neg && sum>9) {
            num[index] = 9;
        }
        else if (neg && sum<0){
            num[index] = 0;
        }
        else {
            num[index]=sum;
            carry = 0;
        }
        return carry;
    }
}
