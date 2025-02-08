package lessons.hw2;

public class ListNode {
    int val;
    ListNode next = null;

    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode current = new ListNode(head.val);

        if(head.next == null) {
            return current;
        }

        ListNode reverse = reverseList(head.next);

        if (reverse.next == null) {
            reverse.next = current;
            return reverse;
        }

        ListNode last = reverse.next;
        while (last.next != null)
            last = last.next;

        last.next = current;

        return reverse;
    }

    public static void print(ListNode head) {
        System.out.println(head.val);
        if(head.next != null) {
            print(head.next);
        }
    }

    public static void main(String[] args) {

        ListNode item_1 = new ListNode(1);
        ListNode item_2 = new ListNode(2,item_1);
        ListNode item_3 = new ListNode(3,item_2);
        ListNode item_4 = new ListNode(4,item_3);
        ListNode item_5 = new ListNode(5,item_4);

        print(reverseList(item_5));
    }
}
