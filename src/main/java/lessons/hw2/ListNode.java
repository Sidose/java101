package lessons.hw2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class to operate with list nodes.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ListNode {
  private int val;
  private ListNode next = null;

  ListNode(int val) {
    this.val = val;
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

    ListNode current = new ListNode(head.getVal());

    if (head.getNext() == null) {
      return current;
    }

    ListNode reverse = reverseList(head.getNext());

    if (reverse.getNext() == null) {
      reverse.setNext(current);
      return reverse;
    }

    ListNode last = reverse.getNext();
    while (last.getNext() != null) {
      last = last.getNext();
    }

    last.setNext(current);

    return reverse;
  }

  /**
   * Prints node list.
   *
   * @param head Head of list node.
   */
  public static void print(ListNode head) {
    System.out.println(head.getVal());
    if (head.getNext() != null) {
      print(head.getNext());
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
