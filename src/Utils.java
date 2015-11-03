
public class Utils {
    static void printArray(int[] a) {
        if (a==null) {
            System.out.print("null");
            return;
        }

        boolean first = true;
        System.out.print("[");
        for (int d: a) {
            if (!first)
                System.out.print(',');
            else
                first = false;
            System.out.print(d);
        }
        System.out.print("]");
    }

    public static void printArray(String[] array) {
        for (String s: array)
            System.out.print(s+" ");
        System.out.println();
    }

    static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
