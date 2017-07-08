package com.dataStructures.LinkedList;

public class ReverseList {

    public static void main(String[] args){

        Node head = new Node();
        head.data = 0;
        Node node = head;

        node = new Node();
        node.data = 1;
        head.next = node;

        node = new Node();
        node.data = 2;
        head.next.next = node;

        node = new Node();
        node.data = 3;
        head.next.next.next = node;

        node = new Node();
        node.data = 4;
        head.next.next.next.next = node;

        node = new Node();
        node.data = 5;
        head.next.next.next.next.next = node;

        node = new Node();
        node.data = 6;
        head.next.next.next.next.next.next = null;

        Node head1 = new Node();
        head1.data = 7;

        node = new Node();
        node.data = 8;
        head1.next = node;

        node = new Node();
        node.data = 9;
        head1.next.next = node;

        head1.next.next.next = head.next.next.next.next.next;

        System.out.println(hasCycle(head));

        if (!hasCycle(head)){
            head = RemoveDuplicates(head);
            node = head;
            while (node != null){
                System.out.println(node.data);
                node = node.next;
            }
        }

        System.out.println(FindMergeNode(head, head1));

    }

    public static int FindMergeNode(Node headA, Node headB) {

        Node front = headA;
        Node rear = headB;

        int headACount = 0;
        int headBCount = 0;

        while(front != null){
            headACount++;
            front = front.next;

        }

        while(rear != null){
            headBCount++;
            rear = rear.next;

        }

        if (headACount > headBCount){

            int diff = headACount - headBCount;
            while (diff > 0){
                headA = headA.next;
                diff--;
            }

        }else if (headBCount > headACount){

            int diff = headBCount - headACount;
            while (diff > 0){
                headB = headB.next;
                diff--;
            }

        }

        while(headA.data != headB.data){

            headA = headA.next;
            headB = headB.next;

        }

        return headB.data;


    }
/*


Node Reverse(Node head) {

    if(head == null){
        return null;
    }

    Node returnHead = null;
    while(head != null){

        Node next = head.next;
        Node prev = head.prev;

        head.prev = next;
        head.next = prev;

        returnHead = head;
        head = head.prev;

    }

    return returnHead;

}



    Node SortedInsert(Node head,int data) {

        if(head == null){
            head = new Node();
            head.data = data;
            return head;
        }

        Node front = head;
        Node prev = front.prev;

        while(front != null && data > front.data){

            prev = front;
            front = front.next;

        }

        if(front == null){
            Node newNode = new Node();
            newNode.data = data;
            prev.next = newNode;
            newNode.prev = prev;

        }else{
            Node newNode = new Node();
            newNode.data = data;
            prev.next = newNode;
            front.prev = newNode;
            newNode.next = front;
            newNode.prev = prev;

        }

        return head;

    }
*/

    public static Node RemoveDuplicates(Node head) {

        if(head == null){
            return head;
        }

        Node front = head;
        Node rear = head;

        while(front != null && front.next != null){

            boolean flag = false;
            while(front.next != null && (front.next.data == front.data)){
                front = front.next;
                flag = true;
            }

            if (flag == true) {
                rear.next = front.next;
                front.next = null;
                front = rear.next;
                rear = rear.next;
            }else {
                front = front.next;
                rear = rear.next;
            }
        }

        return head;

    }

    public static boolean hasCycle(Node head) {

        if (head == null){
            return false;
        }

        Node front = head.next;
        Node rear = head;

        while (front != null && front.next != null){

            if (front.hashCode() == rear.hashCode()){
                return true;
            }

            rear = rear.next;
            front = front.next.next;

        }

        return false;

    }

}

class Node {

    public int data;
    public Node next;

}
