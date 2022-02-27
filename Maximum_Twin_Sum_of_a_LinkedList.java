package LinkedList;
/*
In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node,
if 0 <= i <= (n / 2) - 1.
For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
The twin sum is defined as the sum of a node and its twin.
Given the head of a linked list with even length, return the maximum twin sum of the linked list.
*/
public class Maximum_Twin_Sum_of_a_LinkedList extends Singly_Linked_List{
    private static SingleListNode head;
    public static void main(String[] args) {
        SingleListNode s1 = new SingleListNode(4);
        SingleListNode s2 = new SingleListNode(2);
        SingleListNode s3 = new SingleListNode(2);
        SingleListNode s4 = new SingleListNode(1);

        head = s1;
        s1.setNext(s2);
        s2.setNext(s3);
        s3.setNext(s4);

    }
}
