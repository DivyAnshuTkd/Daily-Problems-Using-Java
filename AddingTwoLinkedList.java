class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Adding {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int num1 = (l1 != null) ? l1.val : 0;
            int num2 = (l2 != null) ? l2.val : 0;

            int sum = num1 + num2 + carry;
            carry = sum / 10;
            sum = sum % 10;

            tail.next = new ListNode(sum);
            tail = tail.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummyHead.next;
    }
}

public class AddingTwoLinkedList {
    // Helper function to create a linked list from an array
    public static ListNode createList(int[] arr) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        for (int num : arr) {
            tail.next = new ListNode(num);
            tail = tail.next;
        }
        return dummyHead.next;
    }

    // Helper function to print a linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example: l1 = [2 -> 4 -> 3], l2 = [5 -> 6 -> 4]
        // Which represents 342 + 465 = 807
        ListNode l1 = createList(new int[]{2, 4, 3});
        ListNode l2 = createList(new int[]{5, 6, 4});

        Adding sol = new Adding();
        ListNode result = sol.addTwoNumbers(l1, l2);

        System.out.print("Result: ");
        printList(result);  // Output: 7 -> 0 -> 8
    }
}
