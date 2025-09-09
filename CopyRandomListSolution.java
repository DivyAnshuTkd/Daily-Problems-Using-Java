// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyRandomListSolution {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // Step 1: Insert cloned nodes in between original nodes
        Node temp = head;
        while (temp != null) {
            Node copyNode = new Node(temp.val);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = copyNode.next;
        }

        // Step 2: Set random pointers for cloned nodes
        temp = head;
        while (temp != null) {
            Node copyNode = temp.next;
            if (temp.random != null) {
                copyNode.random = temp.random.next;
            }
            temp = copyNode.next;
        }

        // Step 3: Separate original list and cloned list
        Node dummyHead = new Node(-1);
        Node res = dummyHead;
        temp = head;

        while (temp != null) {
            Node copyNode = temp.next;
            res.next = copyNode;
            res = res.next;

            temp.next = copyNode.next; // restore original list
            temp = temp.next;
        }

        return dummyHead.next;
    }

    // Utility function to print a list (val + random)
    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            int randomVal = (temp.random != null) ? temp.random.val : -1;
            System.out.print("[" + temp.val + ", random=" + randomVal + "] -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create nodes
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);

        // Connect next pointers
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        // Connect random pointers
        n1.random = null;
        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;

        CopyRandomListSolution solution = new CopyRandomListSolution();

        System.out.println("Original list:");
        solution.printList(n1);

        Node copiedHead = solution.copyRandomList(n1);

        System.out.println("\nCopied list:");
        solution.printList(copiedHead);

        System.out.println("\nOriginal list after copy (should be unchanged):");
        solution.printList(n1);
    }
}
