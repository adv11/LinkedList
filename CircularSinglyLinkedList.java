package LinkedList;

import java.util.NoSuchElementException;

public class CircularSinglyLinkedList{
    private SingleListNode last;
    private int length;

    private class CircularListNode{
        private SingleListNode next;
        private int data;

        public CircularListNode(int data){
            this.data = data;
        }
    }

    public CircularSinglyLinkedList(){
        last = null;
        length = 0;
    }

    // for getting length of the circular LL
    public int getLength(){
        return length;
    }

    // for checking if the CLL is empty or not
    public boolean isEmpty(){
        return length == 0;
    }

    public void createCircularLinkedList(){
        SingleListNode first = new SingleListNode(1);
        SingleListNode second = new SingleListNode(5);
        SingleListNode third = new SingleListNode(10);
        SingleListNode forth = new SingleListNode(15);

        first.setNext(second);
        second.setNext(third);
        third.setNext(forth);
        forth.setNext(first);

        last = forth;
    }

    // for inserting new node at beginning
    public void insertAtBeginning(int data){
        SingleListNode temp = new SingleListNode(data);
        if(last == null)
            last = temp;
        else
            temp.setNext(last.getNext());

        last.setNext(temp);
        length++;
    }

    // for inserting new node at the end
    public void insertAtEnd(int data){
        SingleListNode temp = new SingleListNode(data);
        if(last == null){
            last = temp;
            last.setNext(last);
        }else{
            temp.setNext(last.getNext());
            last.setNext(temp);
            last = temp;
        }
        length++;
    }

    // for displaying the CLL
    public void displayCircularLL(){
        if(last == null)
            return;
        SingleListNode first = last.getNext();
        while(first != last){
            System.out.print(first.getData() + " ");
            first = first.getNext();
        }
        System.out.print(first.getData() + " ");
    }

    // for removing the node from the beginning
    public SingleListNode removeFromBeg(){
        if(isEmpty())
            throw new NoSuchElementException();

        SingleListNode temp = last.getNext();
        if(last.getNext() == last)
            last = null;
        else
            last.setNext(temp.getNext());

        temp.setNext(null);
        length--;
        return temp;
    }
    public static void main(String[] args){
        CircularSinglyLinkedList c1 = new CircularSinglyLinkedList();
        c1.createCircularLinkedList();
        c1.displayCircularLL();

        System.out.println();
        c1.insertAtBeginning(28);
        c1.displayCircularLL();

        System.out.println();
        c1.insertAtEnd(100);
        c1.displayCircularLL();

        System.out.println();
        System.out.println("Removed Data is : " + c1.removeFromBeg().getData());
        c1.displayCircularLL();
    }
}
