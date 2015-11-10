import Interleave.*;
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
        //testLongAddition();
        //testNthLast();
        //testDutchFlag();
        //testInterleave();
        //testArrayIntersection();
        testPermuteString();
    }

    public static void testPermuteString() {
        testPermuteString("a");
        testPermuteString("ab");
        testPermuteString("abc");
    }

    public static void testPermuteString(String s){
        System.out.println(s + ": ");
        Utils.printList(PermuteString.permute(s));
    }

    public static void testArrayIntersection () {
        ArrayIntersection.testArrayIntersection(new int[]{1,2,3}, new int[]{2,3,4}, new int[]{2,3});
        ArrayIntersection.testArrayIntersection(new int[]{1,2,3}, new int[]{4,5,6}, new int[]{});
        ArrayIntersection.testArrayIntersection(new int[]{1}, new int[]{2}, new int[]{});
        ArrayIntersection.testArrayIntersection(new int[]{1}, new int[]{1}, new int[]{1});
        ArrayIntersection.testArrayIntersection(new int[]{1,2,3,3,3}, new int[]{3,3,3}, new int[]{3});
        ArrayIntersection.testArrayIntersection(new int[]{1,1,1,2,3,4,5}, new int[]{1,3,3,3,5,6,7,8}, new int[]{1,3,5});
    }

    public static void testInterleave () {
        Interleave ctr = new Interleave();
        Thread t1 = new PrintInterleave(ctr, 20, true, "A");
        Thread t2 = new PrintInterleave(ctr, 20, false, "B");
        t1.start();
        t2.start();
    }

    public static void testDutchFlag () {
        testDutchFlag(new int[]{1,2,3,1,2,3}, 0);
        testDutchFlag(new int[]{1,2,3,1,2,3}, 1);
        testDutchFlag(new int[]{1,2,3,1,2,3}, 2);
        testDutchFlag(new int[]{1,1}, 0);
        testDutchFlag(new int[]{1,1}, 1);
        testDutchFlag(new int[]{2,1,1}, 0);
        testDutchFlag(new int[]{2,1,1}, 1);
        testDutchFlag(new int[]{1,2,1,2,1,2}, 0);
        testDutchFlag(new int[]{1,2,1,2,1,2}, 1);
        testDutchFlag(new int[]{1,2,3,1,2,3}, 0);
        testDutchFlag(new int[]{1,2,3,1,2,3}, 1);
        testDutchFlag(new int[]{1,2,3,1,2,3}, 2);
        testDutchFlag(new int[]{1,2,1,3,1,4,2,3,2,1}, 1);
    }

    public static void testDutchFlag (int[] a, int pivotIndex) {
        Utils.printArray (a);
        System.out.print(" pivotIndex=" + pivotIndex + ": ");
        DutchFlag.partition(a, pivotIndex);
        Utils.printArray (a);
        System.out.println();
    }

    static void testNthLast () {
        NthLast.Node head = NthLast.buildList(5);
        NthLast.check(head,0,0);
        NthLast.check(head,1,1);
        NthLast.check(head,4,4);
        NthLast.check(head,5,-1);

        head = NthLast.buildList(1);
        NthLast.check(head,0,0);
    }

    static void testLongAddition() {
        LongAddition.test(new int[]{0}, false);
        LongAddition.test(new int[]{1}, false);
        LongAddition.test(new int[]{0}, true);
        LongAddition.test(new int[]{0,0}, true);
        LongAddition.test(new int[]{1}, true);
        LongAddition.test(new int[]{1,0}, true);
        LongAddition.test(new int[]{1,1}, true);
        LongAddition.test(new int[]{9}, false);
        LongAddition.test(new int[]{9,9}, false);
        LongAddition.test(new int[]{5,5,5}, false);
        LongAddition.test(new int[]{5,5,5}, true);
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
        Utils.printArray(Anagram.sort(l));
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
