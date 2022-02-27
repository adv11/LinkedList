package LinkedList;

import java.util.Stack;

public class Intersection_of_two_LinkedList extends Singly_Linked_List{
    private static SingleListNode head1, head2;

    // Brute force Approach
    // Simply checking if the base address of the first list is equal to the
    // base address of the second list. If it is equal then this is the intersection point.
    // TC = O(n*m), SC = O(1)
    // n = length of first linked list, m = length of second linked list
    public static SingleListNode bruteForce(SingleListNode head1, SingleListNode head2){
        SingleListNode temp1 = head1;
        SingleListNode ans = null;

        while(temp1.getNext() != null){
            ans = temp1;
            SingleListNode temp2 = head2;
            while(temp2.getNext() != null){
                if(temp1 == temp2){
                    break;
                }else {
                    temp2 = temp2.getNext();
                }
            }
            temp1 = temp1.getNext();
        }
        return ans;
    }
    // Second brute force approach by using two temporary stacks
    // storing the addresses of the nodes into stacks
    // pop the top elements from both stacks if both are unequal then save it into a variable
    // otherwise stop the loop and return variable
    // TC = O(m+n), SC = O(m+n)
    public static SingleListNode bruteForce_by_stacks(SingleListNode head1, SingleListNode head2){
        Stack<SingleListNode> stack1 = new Stack<>();
        Stack<SingleListNode> stack2 = new Stack<>();

        SingleListNode temp1 = head1, temp2 = head2;
        // storing the addresses of first linked list into the first stack
        while(temp1.getNext() != null){
            stack1.push(temp1);
            temp1 = temp1.getNext();
        }
        // storing the addresses of second linked list into the second stack
        while(temp2.getNext() != null){
            stack2.push(temp2);
            temp2 = temp2.getNext();
        }

        int size = Math.max(stack1.size(), stack2.size());
        SingleListNode ans = null;
        while (size-- > 0){
            SingleListNode t1 = stack1.pop();
            SingleListNode t2 = stack2.pop();

            if(t1 == t2){
                ans = t1;
            }else{
                break;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        // creating first linked list
        SingleListNode s1 = new SingleListNode(1);
        SingleListNode s2 = new SingleListNode(2);
        SingleListNode s3 = new SingleListNode(3);
        SingleListNode s4 = new SingleListNode(4);
        SingleListNode s5 = new SingleListNode(5);
        head1 = s1;
        s1.setNext(s2);
        s2.setNext(s3);
        s3.setNext(s4);
        s4.setNext(s5);

        // creating second linked list
        SingleListNode l1 = new SingleListNode(6);
        SingleListNode l2 = new SingleListNode(7);
        SingleListNode l3 = new SingleListNode(8);
        head2 = l1;
        l1.setNext(l2);
        l2.setNext(l3);
        l3.setNext(s4); // at this point both the linked list intersected each other

        // first brute force
        System.out.println(bruteForce(head1, head2).getData());

        // second brute force by stacks
        System.out.println(bruteForce_by_stacks(head1, head2).getData());
    }
}
