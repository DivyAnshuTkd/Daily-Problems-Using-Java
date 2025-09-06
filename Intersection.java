class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Intersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;

        int count1 = 0;
        int count2 = 0;

        // Count length of list A
        while (temp1 != null) {
            temp1 = temp1.next;
            count1++;
        }

        // Count length of list B
        while (temp2 != null) {
            temp2 = temp2.next;
            count2++;
        }

        temp1 = headA;
        temp2 = headB;

        int count = count1 - count2;

        // Align both lists by skipping the extra nodes in the longer list
        while (count != 0) {
            if (count < 0) {
                temp2 = temp2.next;
                count++;
            } else {
                temp1 = temp1.next;
                count--;
            }
        }

        // Traverse together until intersection is found
        while (temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return temp1; // returns null if no intersection
    }

    public static void main(String[] args) {
        // Create two linked lists

        // List A: 1 -> 2 -> 3 \
        //                       6 -> 7
        // List B:       4 -> 5 /

        ListNode common = new ListNode(6);
        common.next = new ListNode(7);

        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(3);
        headA.next.next.next = common; // intersection starts here

        ListNode headB = new ListNode(4);
        headB.next = new ListNode(5);
        headB.next.next = common; // intersection starts here

        Intersection sol = new Intersection();
        ListNode intersection = sol.getIntersectionNode(headA, headB);

        if (intersection != null) {
            System.out.println("Intersection Node value: " + intersection.val);
        } else {
            System.out.println("No Intersection");
        }
    }
}
