package LinkedList;

public class Singly_Linked_List{
    public static SingleListNode head;

    // method for inserting new node at the beginning of the linked list
    public static void insertAtBegin(SingleListNode newNode){
        newNode.setNext(head);
        head = newNode;
    }

    // method for inserting new node at the end of the linked list
    public static void insertAtEnd(SingleListNode newNode){
        if(head == null){
            head = newNode;
        }else{
            SingleListNode temp = head;
            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
    }

    // method for inserting new node at any specific position
    public static void insertAtPosition(SingleListNode newNode, int position){
        if(position < 0){
            System.out.println("Invalid Position.");
        }else{
            SingleListNode temp = head;
            while((position-1) !=0){
                temp = temp.getNext();
                position--;
            }
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
        }
    }

    // method for printing linked list
    public static void printLinkedList(SingleListNode head){
        SingleListNode temp = head;
        while(temp != null){
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
    }

    // method for deleting node from the beginning of the Linked List
    public static void deleteNodeAtBeginning(){
        if(head != null){
            head = head.getNext();
        }
    }

    // method for deleting node at the end of the linked list
    public static void deleteAtEnd(){
        if(head == null){
            System.out.println("There is not node to delete.");
        }else{
            SingleListNode prev = head;
            SingleListNode next = head.getNext();

            while(next.getNext() != null){
                prev = next;
                next = next.getNext();
            }
            prev.setNext(null);
        }
    }

    public static void deleteAtPosition(int position){
        if(head == null){
            System.out.println("There is no node to delete.");
        }else{
            SingleListNode prev = head;
            SingleListNode next = head.getNext();
            while((position-2) != 0){
                prev = next;
                next = next.getNext();
                position--;
            }
            prev.setNext(next.getNext());
        }
    }

    // method for finding the length of the linked list
    public static int findLength(){
        int length = 0;
        SingleListNode temp = head;
        while(temp != null){
            length++;
            temp = temp.getNext();
        }
        return length;
    }

    // reversing the linked list
    public static SingleListNode reverseLinkedList(SingleListNode head){
        if(head == null) {
            return head;
        }
        SingleListNode current = head;
        SingleListNode previous = null;
        SingleListNode next = null;

        while(current != null){
            next = current.getNext();   // ncn
            current.setNext(previous);  // csp
            previous = current; // pc
            current = next; // cn
        }
        return previous;
    }

    // finding the middle node in the linked list
    public static int returnMiddleNode(SingleListNode head, int linkedListLength){
        int middleElement = -1;
        if(head == null){
            return middleElement;
        }else{
            int tempPosition = (int) Math.ceil(linkedListLength/2);
            SingleListNode tempNode = head;
            while(tempPosition != 0){
                tempNode = tempNode.getNext();
                tempPosition--;
            }
            middleElement = tempNode.getData();
        }
        return middleElement;
    }

    public static void main(String[] args) {
        SingleListNode l1 = new SingleListNode(10);
        SingleListNode l2 = new SingleListNode(20);
        SingleListNode l3 = new SingleListNode(30);

        head = l1;
        l1.setNext(l2);
        l2.setNext(l3);

        printLinkedList(head);  // output : 10 20 30

        System.out.println();
        insertAtBegin(new SingleListNode(40));
        printLinkedList(head);  // output : 40 10 20 30

        System.out.println();
        insertAtEnd(new SingleListNode(50));
        printLinkedList(head);  // output : 40 10 20 30 50

        System.out.println();
        insertAtPosition(new SingleListNode(100), 3);
        printLinkedList(head);  // output : 40 10 20 100 30 50

        System.out.println();
        deleteNodeAtBeginning();
        printLinkedList(head);  // output : 10 20 100 30 50

        System.out.println();
        deleteAtEnd();
        printLinkedList(head);  // output : 10 20 100 30

        System.out.println();
        deleteAtPosition(3);
        printLinkedList(head);  // output : 10 20 30

        System.out.println();
        System.out.println("Length of the linked list is : " + findLength());   // output : 3

        System.out.println("After reversing the linked list:");
        SingleListNode reversedHead = reverseLinkedList(head);  // it will return the new head after reversing the linked list
        printLinkedList(reversedHead);  // passing the new head in the printLinkedList method
        // output : 30 20 10

        // making the head as the original head again
        head = reversedHead;

        System.out.println();
        System.out.println("Middle node is : " + returnMiddleNode(head, findLength())); // output : 20
    }
}
