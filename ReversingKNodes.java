/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class ReversingKNodes {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        // Count total nodes
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        int groups = count / k;

        // Dummy node to simplify head handling
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode prev = dummyNode;

        while (groups > 0) {
            ListNode curr = prev.next;
            ListNode nextNode = curr.next;

            // Reverse k nodes
            for (int i = 1; i < k; i++) {
                curr.next = nextNode.next;
                nextNode.next = prev.next;
                prev.next = nextNode;
                nextNode = curr.next;
            }

            // Move prev to end of reversed group
            prev = curr;
            groups--;
        }
        return dummyNode.next;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2; // group size

        ReversingKNodes sol = new ReversingKNodes();
        ListNode result = sol.reverseKGroup(head, k);

        // Print reversed list
        System.out.print("Reversed in groups of " + k + ": ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
