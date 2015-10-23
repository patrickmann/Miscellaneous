import ProducerConsumer.Consumer;
import ProducerConsumer.MyQ;
import ProducerConsumer.Producer;

public class Main {
    public static void main (String[] args) {
        //testProducerConsumer();
        //Join.runJoin();
        //testFindSubstring();
        //testSortAlternating();
        //testSumPairs();
        //testIsland();
        //testAnagram();
        testPrintGaps();
    }

    static public void testPrintGaps () {
        PrintGaps.printGaps(new int[]{1}, 99);
        PrintGaps.printGaps(new int[]{1,2,5,99}, 99);
        PrintGaps.printGaps(new int[]{2,55,98}, 99);
        PrintGaps.printGaps(new int[]{3,55,56,58,97}, 99);
    }

    static void testAnagram(){
        String[] l = {"abc", "def", "aba", "cba", "baa"};
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
        SumPairs.printPairsWithDupes(a1, 5);
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
