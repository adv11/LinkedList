package LinkedList;
/*
Given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each pd their
nodes contains a single digit. Add the two numbers and return the sum as a linked list. You may assume the two numbers do not contain
any leading zero, except the number 0 itself.

Example :
Input : a : [3, 4, 3], b : [5, 6, 4]
Output : result : [8, 0, 8]
*/
public class Add_two_numbers extends Singly_Linked_List{
    public static SingleListNode addTwoNumbers(SingleListNode head1, SingleListNode head2){
        SingleListNode t1=head1, t2 = head2;
        SingleListNode dummy = new SingleListNode(0);
        SingleListNode tail = dummy;
        int carry = 0;

        while(t1 != null || t2 != null){
            int x = (t1 != null) ? t1.getData() : 0;
            int y = (t2 != null) ? t2.getData() : 0;
            int sum = x + y + carry;
            carry = sum/10;

            tail.setNext(new SingleListNode(sum % 10));
            tail = tail.getNext();
            if(t1 != null)
                t1 = t1.getNext();
            if(t2 != null)
                t2 = t2.getNext();
        }
        if(carry > 0)
            tail.setNext(new SingleListNode(carry));
        return dummy.getNext();
    }
    public static void main(String[] args) {
        SingleListNode s1 = new SingleListNode(7);
        SingleListNode s2 = new SingleListNode(2);
        SingleListNode s3 = new SingleListNode(4);
        SingleListNode s4 = new SingleListNode(3);
        SingleListNode head1 = s1;
        s1.setNext(s2);
        s2.setNext(s3);
        s3.setNext(s4);

        SingleListNode l1 = new SingleListNode(5);
        SingleListNode l2 = new SingleListNode(6);
        SingleListNode l3 = new SingleListNode(4);
        SingleListNode head2 = l1;
        l1.setNext(l2);
        l2.setNext(l3);

        printLinkedList(addTwoNumbers(head1, head2));
    }
}
