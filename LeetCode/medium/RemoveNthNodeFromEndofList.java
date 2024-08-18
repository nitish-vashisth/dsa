package LeetCode.medium;

//19. Remove Nth Node From End of List

public class RemoveNthNodeFromEndofList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head.next==null && n==1){
            head = null;
            return head;
        }

        ListNode first = head;
        ListNode second = head;

        while(n > 0) {
            second = second.next;
            n--;
        }

        if(second == null) { // this means this is first node
            ListNode temp = head;
            head = head.next;
            temp.next = null;
            return head;
        }

        while(second.next !=null) {
            second = second.next;
            first = first.next;
        }

        ListNode temp = first.next;
        first.next = temp.next;
        temp.next = null;

        return head;
    }

}
