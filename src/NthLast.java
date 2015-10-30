public class NthLast {

    public static class Node {
        int value;
        Node next;

        Node(Node next, int value) {
            this.next = next;
            this.value = value;
        }
    }

    // Find the nth last element in a singly linked list, where n=0 means the last element,
    // n=1 the next to last, etc.
    // Return null for invalid parameters
    // Negative n are treated as positive
    public static Node getNthLastElement(Node head, int n) {
        if (head == null) return null;
        if (n < 0) n = n * -1;

        Node p1, p2;
        p1 = head;
        for (int i = 0; i <= n; i++) {
            if (p1 == null) return null;
            p1 = p1.next;
        }

        p2 = head;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    // Create a test list of n elements and return the head element
    public static Node buildList(int n) {
        if (n == 0) return null;

        Node head = new Node(null, 0);
        if (n == 1) return head;

        for (int i = 0; i < n - 1; i++) {
            Node node = new Node(head, i + 1);
            head = node;
        }
        return head;
    }

    // Run a test with the given list and n value and compare result with expected
    public static void check(Node head, int n, int expected) {
        Node node = getNthLastElement(head, n);

        if (expected == -1) {
            if (node == null) {
                System.out.print("PASS: null");
            } else {
                System.out.print("FAIL: " + node.value);
            }
        }
        else if (node.value != expected)
            System.out.print("FAIL: " + node.value);
        else
            System.out.print("PASS: " + node.value);

        System.out.print(" - expected " + ((expected==-1)?"null":expected) + " ");
        printList(head);
        System.out.println(n);
    }

    // print the given list
    private static void printList(Node head) {
        if (head == null) {
            System.out.println("null");
            return;
        }

        Node p = head;
        System.out.print("[");
        while (p != null) {
            System.out.print(p.value + " ");
            p = p.next;
        }
        System.out.print("]");
    }
}
