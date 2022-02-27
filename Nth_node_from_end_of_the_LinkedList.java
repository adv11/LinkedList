package LinkedList;
/*
Remove the kth node from end of the linked list.
Example :
>> Input : [1, 2, 3, 4, 5] , k = 2
>> Output : [1, 2, 3, 5]
*/
import java.util.Scanner;

public class Nth_node_from_end_of_the_LinkedList extends Singly_Linked_List{
    public static SingleListNode head;

    // function for finding the node from the end of the linked list
    public static int find_nth_node_from_end(int nodeNumber, int totalLength){
        // present index of the result node from the front will be
        // total length - index from end of the linked list
        int nodeFromFront = (totalLength - nodeNumber);
        SingleListNode t = head;

        while(nodeFromFront > 0){
            t = t.getNext();
            nodeFromFront--;
        }
        return t.getData();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SingleListNode sl1 = new SingleListNode(10);
        SingleListNode sl2 = new SingleListNode(20);
        SingleListNode sl3 = new SingleListNode(30);
        SingleListNode sl4 = new SingleListNode(40);
        SingleListNode sl5 = new SingleListNode(50);
        SingleListNode sl6 = new SingleListNode(60);
        SingleListNode sl7 = new SingleListNode(70);
        SingleListNode sl8 = new SingleListNode(80);
        SingleListNode sl9 = new SingleListNode(90);
        SingleListNode sl10 = new SingleListNode(100);

        head = sl1;
        sl1.setNext(sl2);
        sl2.setNext(sl3);
        sl3.setNext(sl4);
        sl4.setNext(sl5);
        sl5.setNext(sl6);
        sl6.setNext(sl7);
        sl7.setNext(sl8);
        sl8.setNext(sl9);
        sl9.setNext(sl10);

        System.out.println("Enter which node to find from end:");
        int nodeNumber = sc.nextInt();

        // finding total length of the linked list
        SingleListNode t = head;
        int totalLength = 0;
        while(t != null){
            t = t.getNext();
            totalLength++;
        }

        // calling the function
        System.out.println("Data of the node from the end of the linked list is :");
        System.out.println(find_nth_node_from_end(nodeNumber, totalLength));
    }
}
