import ProducerConsumer.Consumer;
import ProducerConsumer.MyQ;
import ProducerConsumer.Producer;

import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        //foo.test();
        //testProducerConsumer();
        //Join.runJoin();
        //testFindSubstring();
        //testSortAlternating();
        //testSumPairs();
        //testIsland();
        //testAnagram();
        //testPrintGaps();
        //testSubSort();
        testLongAddition();
    }

    static void testLongAddition() {
        int[] a1 = {0};
        int[] a2 = {1};
        int[] a3 = {0};
        int[] a4 = {1};
        int[] a5 = {9};
        int[] a6 = {9,9};
        int[] a7 = {5,5,5};
        System.out.println(Arrays.toString(a1) + " " + Arrays.toString(LongAddition.add(a1, false)));
        System.out.println(Arrays.toString(a2) + " " + Arrays.toString(LongAddition.add(a2, false)));
        System.out.println("-" + Arrays.toString(a3) + " " + Arrays.toString(LongAddition.add(a3, true)));
        System.out.println("-" + Arrays.toString(a4) + " " + Arrays.toString(LongAddition.add(a4, true)));
        System.out.println(Arrays.toString(a5) + " " + Arrays.toString(LongAddition.add(a5, false)));
        System.out.println(Arrays.toString(a6) + " " + Arrays.toString(LongAddition.add(a6, false)));
        System.out.println(Arrays.toString(a7) + " " + Arrays.toString(LongAddition.add(a7, false)));
        System.out.println("-" + Arrays.toString(a7) + " " + Arrays.toString(LongAddition.add(a7, true)));
    }

    static void testSubSort(){
        int[]a1 = {2,1};
        int[]a2 = {1,3,2};
        int[]a3 = {2,1,3};
        int[]a4 = {4,5,1,2,3,8,9};
        int[]a5 = {1,2,3,8,9,5,4};

        SubSort.subSort(a1);
        SubSort.subSort(a2);
        SubSort.subSort(a3);
        SubSort.subSort(a4);
        SubSort.subSort(a5);
    }

    static public void testPrintGaps () {
        PrintGaps.printGaps(new int[]{1}, 99); //2-99
        PrintGaps.printGaps(new int[]{1,2,5,99}, 99); //3-4,6-98
        PrintGaps.printGaps(new int[]{2,55,98}, 99); //1,3-54,56-97,99
        PrintGaps.printGaps(new int[]{3,55,56,58,97}, 99); //1-2,4-54,57,59-96,98-99
        PrintGaps.printGaps(new int[]{1,2,3}, 3); // ""
    }

    static void testAnagram(){
        String[] l = {"def", "abc", "aba", "cba", "baa"};
        Anagram.print(Anagram.sort(l));
    }

    static void testIsland() {
        char[][]map1 = {
                {'X', '0', '0'},
                {'0', 'X', '0'},
                {'0', '0', 'X'}};
        Islands.testCountIslands(map1, 3);

        char[][]map2 = {
                {'X', 'X', '0'},
                {'X', 'X', '0'},
                {'0', '0', 'X'}};
        Islands.testCountIslands(map2, 2);

        char[][]map3 = {
                {'X'}};
        Islands.testCountIslands(map3, 1);

        char[][]map4 = {
                {'0'}};
        Islands.testCountIslands(map3, 0);
    }

    static void testSumPairs(){
        int[] a1 = {1,2,3,4,5};
        SumPairs.printPairs(a1, 5);

        int[] a2 = {1,2,3,4,5,1,2,3,4,5};
        SumPairs.printPairsWithDupes(a2, 5);
    }

    static void testSortAlternating() {
        int[] a1 = {1,2,3,4,5};
        SortAlternating.sort(a1);

        int[] a2 = {1};
        SortAlternating.sort(a2);

        int[] a3 = {1,2};
        SortAlternating.sort(a3);

        int[] a4 = {2,1};
        SortAlternating.sort(a4);
    }

    static void testFindSubstring(){
        LongestSubstring.find("abcabc");
        LongestSubstring.find("abc");
        LongestSubstring.find("abcdafgh");
    }

    static void testProducerConsumer(){
        MyQ q = new MyQ();
        Consumer c = new Consumer(q);
        Producer p = new Producer(q);

        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);
        t1.start();
        t2.start();
    }
}
