package lessons.hw2;

/**
 * Class to operate with list nodes.
 */
public class ListNode {
  int val;
  ListNode next = null;

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  /**
   * Reverses list node.
   *
   * @param head Head of list node.
   * @return Reversed list node.
   */
  public static ListNode reverseList(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode current = new ListNode(head.val);

    if (head.next == null) {
      return current;
    }

    ListNode reverse = reverseList(head.next);

    if (reverse.next == null) {
      reverse.next = current;
      return reverse;
    }

    ListNode last = reverse.next;
    while (last.next != null) {
      last = last.next;
    }

    last.next = current;

    return reverse;
  }

  /**
   * Prints node list.
   *
   * @param head Head of list node.
   */
  public static void print(ListNode head) {
    System.out.println(head.val);
    if (head.next != null) {
      print(head.next);
    }
  }

  /**
   * Main method.
   *
   * @param args Arguments.
   */
  public static void main(String[] args) {

    ListNode item1 = new ListNode(1);
    ListNode item2 = new ListNode(2, item1);
    ListNode item3 = new ListNode(3, item2);
    ListNode item4 = new ListNode(4, item3);
    ListNode item5 = new ListNode(5, item4);

    print(reverseList(item5));
  }
}
